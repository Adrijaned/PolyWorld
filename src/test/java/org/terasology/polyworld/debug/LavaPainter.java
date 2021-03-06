/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.polyworld.debug;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import org.terasology.math.geom.BaseVector2f;
import org.terasology.polyworld.graph.Edge;
import org.terasology.polyworld.graph.Graph;
import org.terasology.polyworld.lava.LavaModel;

/**
 * Draws the generated rivers on a AWT graphics instance
 */
public class LavaPainter {

    private Color lavaColor = new Color(0xcc3333);

    /**
     */
    public LavaPainter() {
    }

    /**
     * @param g
     * @param lavaModel
     * @param graph
     */
    public void drawLava(Graphics2D g, LavaModel lavaModel, Graph graph) {
        for (Edge e : graph.getEdges()) {
            if (lavaModel.isLava(e)) {
                g.setStroke(new BasicStroke(2));
                g.setColor(lavaColor);
                BaseVector2f c0p = e.getCorner0().getLocation();
                BaseVector2f c1p = e.getCorner1().getLocation();
                g.drawLine((int) c0p.getX(), (int) c0p.getY(), (int) c1p.getX(), (int) c1p.getY());
            }
        }
        g.setStroke(new BasicStroke());
    }

    /**
     * @param color the lava color
     */
    public void setLavaColor(Color color) {
        this.lavaColor = color;
    }
}
