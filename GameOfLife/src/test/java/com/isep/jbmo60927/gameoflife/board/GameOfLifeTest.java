package com.isep.jbmo60927.gameoflife.board;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.isep.jbmo60927.gameoflife.error.GameOfLifeException;

public class GameOfLifeTest {
    @Test
    public void testErrorInit() {
        try {
            new GameOfLife(0, 0, new Coord[] {new Coord(0, 0)});
            assertTrue(false);
        } catch (GameOfLifeException e) {
            assertTrue(true);
        }
        try {
            new GameOfLife(2, 2, new Coord[] {new Coord(0, 0)});
            assertTrue(true);
        } catch (GameOfLifeException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testCountlivingNeighbours() {
        assertEquals(0, GameOfLife.countlivingNeighbours(0, 0, 5, 5, new int[][] {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        }));
        assertEquals(0, GameOfLife.countlivingNeighbours(0, 0, 5, 5, new int[][] {
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        }));
        assertEquals(0, GameOfLife.countlivingNeighbours(1, 1, 5, 5, new int[][] {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        }));
        assertEquals(0, GameOfLife.countlivingNeighbours(1, 1, 5, 5, new int[][] {
            {0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        }));
        assertEquals(3, GameOfLife.countlivingNeighbours(1, 1, 5, 5, new int[][] {
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        }));
        assertEquals(3, GameOfLife.countlivingNeighbours(1, 1, 5, 5, new int[][] {
            {0, 1, 1, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        }));
        assertEquals(8, GameOfLife.countlivingNeighbours(1, 1, 5, 5, new int[][] {
            {1, 1, 1, 0, 0},
            {1, 0, 1, 0, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        }));
        assertEquals(0, GameOfLife.countlivingNeighbours(1, 1, 5, 5, new int[][] {
            {0, 0, 0, 1, 1},
            {0, 1, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1}
        }));
        assertEquals(0, GameOfLife.countlivingNeighbours(2, 2, 5, 5, new int[][] {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        }));
        assertEquals(3, GameOfLife.countlivingNeighbours(2, 2, 5, 5, new int[][] {
            {1, 1, 1, 1, 1},
            {1, 1, 0, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1}
        }));
    }

    @Test
    public void testInitGrid() {
        assertArrayEquals(new int[][] {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        }, GameOfLife.initGrid(5, 5));
        assertArrayEquals(new int[][] {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
        }, GameOfLife.initGrid(3, 3));
        assertArrayEquals(new int[][] {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        }, GameOfLife.initGrid(3, 5));
        assertArrayEquals(new int[0][0], GameOfLife.initGrid(-1, -1));
    }

    @Test
    public void testSetLivingCells() {
        try {
            GameOfLife gol = new GameOfLife(3, 3, new Coord[] {});
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol.setLivingCells(new Coord[] {new Coord(0, 0)});
            assertArrayEquals(new int[][] {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol = new GameOfLife(3, 3, new Coord[] {});
            gol.setLivingCells(new Coord[] {new Coord(1, 0), new Coord(2, 0)});
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {1, 0, 0},
                {1, 0, 0}
            }, gol.getGrid());
            gol = new GameOfLife(3, 3, new Coord[] {});
            gol.setLivingCells(new Coord[] {new Coord(0, 1)});
            assertArrayEquals(new int[][] {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol = new GameOfLife(3, 3, new Coord[] {});
            gol.setLivingCells(new Coord[] {new Coord(2, 2)});
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
            }, gol.getGrid());
            gol = new GameOfLife(3, 3, new Coord[] {});
            gol.setLivingCells(new Coord[] {new Coord(4, 4)});
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol = new GameOfLife(3, 3, new Coord[] {});
            gol.setLivingCells(new Coord[] {new Coord(-1, -1)});
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol = new GameOfLife(3, 5, new Coord[] {});
            gol.setLivingCells(new Coord[] {new Coord(2, 4)});
            assertArrayEquals(new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
            }, gol.getGrid());
        } catch (GameOfLifeException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testIsInTheGrid() {
        assertEquals(Boolean.TRUE, GameOfLife.isInTheGrid(0,0,3,3));
        assertEquals(Boolean.TRUE, GameOfLife.isInTheGrid(4,4,5,5));
        assertEquals(Boolean.FALSE, GameOfLife.isInTheGrid(-1,-1,5,5));
        assertEquals(Boolean.FALSE, GameOfLife.isInTheGrid(0,-1,5,5));
        assertEquals(Boolean.FALSE, GameOfLife.isInTheGrid(-1,0,5,5));
        assertEquals(Boolean.FALSE, GameOfLife.isInTheGrid(5,5,5,5));
        assertEquals(Boolean.FALSE, GameOfLife.isInTheGrid(5,0,5,5));
        assertEquals(Boolean.FALSE, GameOfLife.isInTheGrid(0,5,5,5));
    }

    @Test
    public void testComputeNextGeneration() {
        try {

            //case 1
            GameOfLife gol = new GameOfLife(3, 3, new Coord[] {new Coord(0, 1), new Coord(1, 0), new Coord(2, 0)});
            assertArrayEquals(new int[][] {
                {0, 1, 0},
                {1, 0, 0},
                {1, 0, 0}
            }, gol.getGrid());
            gol.computeNextGeneration();
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol.computeNextGeneration();
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());

            //case 2
            gol = new GameOfLife(3, 3, new Coord[] {new Coord(0, 1), new Coord(1, 1), new Coord(2, 1)});
            assertArrayEquals(new int[][] {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
            }, gol.getGrid());
            gol.computeNextGeneration();
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
            }, gol.getGrid());
            gol.computeNextGeneration();
            assertArrayEquals(new int[][] {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
            }, gol.getGrid());
            gol.computeNextGeneration();
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
            }, gol.getGrid());

            //case 3
            gol = new GameOfLife(4, 4, new Coord[] {new Coord(1, 1), new Coord(1, 2), new Coord(2, 1)});
            assertArrayEquals(new int[][] {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}
            }, gol.getGrid());
            gol.computeNextGeneration();
            assertArrayEquals(new int[][] {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
            }, gol.getGrid());
            gol.computeNextGeneration();
            assertArrayEquals(new int[][] {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
            }, gol.getGrid());

            //case 4
            gol = new GameOfLife(3, 3, new Coord[] {new Coord(2, 0), new Coord(1, 1), new Coord(0, 2)});
            assertArrayEquals(new int[][] {
                {0, 0, 1},
                {0, 1, 0},
                {1, 0, 0}
            }, gol.getGrid());
            gol.computeNextGeneration();
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol.computeNextGeneration();
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
        } catch (GameOfLifeException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testComputeNthGeneration() {
        try {

            //case 1
            GameOfLife gol = new GameOfLife(3, 3, new Coord[] {new Coord(0, 1), new Coord(1, 0), new Coord(2, 0)});
            assertArrayEquals(new int[][] {
                {0, 1, 0},
                {1, 0, 0},
                {1, 0, 0}
            }, gol.getGrid());
            gol.computeNthGeneration(10);
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());

            //case 2
            gol = new GameOfLife(3, 3, new Coord[] {new Coord(0, 1), new Coord(1, 1), new Coord(2, 1)});
            assertArrayEquals(new int[][] {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
            }, gol.getGrid());
            gol.computeNthGeneration(11);
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
            }, gol.getGrid());

            //case 3
            gol = new GameOfLife(4, 4, new Coord[] {new Coord(1, 1), new Coord(1, 2), new Coord(2, 1)});
            assertArrayEquals(new int[][] {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}
            }, gol.getGrid());
            gol.computeNthGeneration(10);
            assertArrayEquals(new int[][] {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
            }, gol.getGrid());

            //case 4
            gol = new GameOfLife(3, 3, new Coord[] {new Coord(2, 0), new Coord(1, 1), new Coord(0, 2)});
            assertArrayEquals(new int[][] {
                {0, 0, 1},
                {0, 1, 0},
                {1, 0, 0}
            }, gol.getGrid());
            gol.computeNthGeneration(10);
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
        } catch (GameOfLifeException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testSetLivingCell() {
        try {
            GameOfLife gol = new GameOfLife(3, 3, new Coord[0]);
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol.setLivingCell(0, 0);
            assertArrayEquals(new int[][] {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol = new GameOfLife(3, 3, new Coord[0]);
            gol.setLivingCell(1, 0);
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {1, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol = new GameOfLife(3, 3, new Coord[0]);
            gol.setLivingCell(0, 1);
            assertArrayEquals(new int[][] {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol = new GameOfLife(3, 3, new Coord[0]);
            gol.setLivingCell(2, 2);
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
            }, gol.getGrid());
            gol = new GameOfLife(3, 3, new Coord[0]);
            gol.setLivingCell(4, 4);
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol = new GameOfLife(3, 3, new Coord[0]);
            gol.setLivingCell(-1, -1);
            assertArrayEquals(new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, gol.getGrid());
            gol = new GameOfLife(3, 5, new Coord[0]);
            gol.setLivingCell(2, 4);
            assertArrayEquals(new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
            }, gol.getGrid());
        } catch (GameOfLifeException e) {
            assertTrue(false);
        }
    }
}
