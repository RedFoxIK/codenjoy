package com.codenjoy.dojo.services.joystick;

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


import com.codenjoy.dojo.services.Joystick;

/**
 * Created by indigo on 2016-11-23.
 */
public abstract class ActJoystick implements Joystick {

    @Override
    public void message(String command) {
        // do nothing
    }

    @Override
    public void down() {
        // do nothing
    }

    @Override
    public void up() {
        // do nothing
    }

    @Override
    public void left() {
        // do nothing
    }

    @Override
    public void right() {
        // do nothing
    }
}
