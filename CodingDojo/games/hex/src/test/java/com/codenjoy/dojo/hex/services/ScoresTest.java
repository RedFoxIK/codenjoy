package com.codenjoy.dojo.hex.services;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.services.PlayerScores;
import com.codenjoy.dojo.services.settings.Settings;
import com.codenjoy.dojo.services.settings.SettingsImpl;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: sanja
 * Date: 05.06.13
 * Time: 20:35
 */
public class ScoresTest {
    private PlayerScores scores;

    private Settings settings;
    private Integer loosePenalty;
    private Integer winScore;

    public void loose(int count) {
        scores.event(new Event(Event.EventEnum.LOOSE, count));
    }

    public void win(int count) {
        scores.event(new Event(Event.EventEnum.WIN, count));
    }

    @Before
    public void setup() {
        settings = new SettingsImpl();
        scores = new Scores(0, settings);

        loosePenalty = settings.getParameter("Loose penalty").type(Integer.class).getValue();
        winScore = settings.getParameter("Win score").type(Integer.class).getValue();
    }

    @Test
    public void shouldCollectScores() {
        scores = new Scores(140, settings);

        win(1);  //+30
        win(1);  //+30
        win(1);  //+30
        win(2);  //+60

        loose(1); //-100

        assertEquals(140 + 5 * winScore - loosePenalty, scores.getScore());
    }

    @Test
    public void shouldStillZeroAfterDead() {
        loose(1);    //-100

        assertEquals(0, scores.getScore());
    }

    @Test
    public void shouldClearScore() {
        win(1);    // +30

        scores.clear();

        assertEquals(0, scores.getScore());
    }


}
