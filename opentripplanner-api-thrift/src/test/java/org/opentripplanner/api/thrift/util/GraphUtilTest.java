/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.api.thrift.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.opentripplanner.api.thrift.definition.GraphVertex;
import org.opentripplanner.api.thrift.definition.LatLng;
import org.opentripplanner.api.thrift.definition.Location;
import org.opentripplanner.routing.graph.Graph;
import org.opentripplanner.routing.graph.Vertex;
import org.opentripplanner.routing.vertextype.StreetVertex;

/**
 * Tests for GraphUtil class. 
 * 
 * @author flamholz
 */
public class GraphUtilTest {
    
    private Graph _graph;

    @Before
    public void before() {
        _graph = new Graph();
    }
    
    @Test
    public void testMakeGraphVertices() {
    	List<Vertex> vs = new ArrayList<Vertex>(3);
    	vs.add(vertex("fake1", 47.666863,  -122.382106));
    	vs.add(vertex("fake2", 47.666854,  -122.382103));
    	vs.add(vertex("fake3", 47.666891,  -122.382112));
    	
    	List<GraphVertex> gvs = GraphUtil.makeGraphVertices(_graph);
    	assertEquals(vs.size(), gvs.size());
    	
    	// TODO(flamholz): compare actual vertices.
    	// This is annoying because the graph stores them in an unordered
    	// fashion, meaning I need to write a set comparator for vertices. 
    	// not worth the time.
    }
    
    /****
     * Private Methods
     ****/

    private SimpleVertex vertex(String label, double lat, double lon) {
        SimpleVertex v = new SimpleVertex(_graph, label, lat, lon);
        return v;
    }

    private static class SimpleVertex extends StreetVertex {

        private static final long serialVersionUID = 1L;

        public SimpleVertex(Graph g, String label, double lat, double lon) {
            super(g, label, lon, lat, label);
        }
    }

}
