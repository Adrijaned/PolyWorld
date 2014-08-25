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

package org.terasology.polyworld.voronoi;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import org.terasology.math.geom.Vector2d;

import com.google.common.base.Preconditions;

/**
 * Defines a polygon region (vornoi region)
 * @author Martin Steiger
 */
public class Region {

    private final Collection<Corner> corners = new LinkedHashSet<>();
    private final Collection<Edge> borders = new LinkedHashSet<>();

    private final Collection<Region> neighbors = new LinkedHashSet<>();

    private final Vector2d center;

    public Region(Vector2d pos) {
        this.center = pos;
    }

    /**
     * @return the pos
     */
    public Vector2d getCenter() {
        return center;
    }

    public Collection<Region> getNeighbors() {
        return Collections.unmodifiableCollection(neighbors);
    }

    /**
     * @param region the region to add (can be null or already added)
     */
    public void addNeigbor(Region region) {
        if (region != null) {
            neighbors.add(region);
        }
    }

    /**
     * @param edge the border edge to add  (can be null or already added)
     */
    public void addBorder(Edge edge) {
        if (edge != null) {
            borders.add(edge);
        }
    }

    /**
     * @return the corners
     */
    public Collection<Corner> getCorners() {
        return Collections.unmodifiableCollection(corners);
    }

    /**
     * @param c the corner to add (can be null or already added)
     */
    public void addCorner(Corner c) {
        if (c != null) {
            corners.add(c);
        }
    }

    @Override
    public String toString() {
        return String.format("Region [center=%s, corners=%s, borders=%s, neighbors=%s]", center, corners.size(), borders.size(), neighbors.size());
    }


}
