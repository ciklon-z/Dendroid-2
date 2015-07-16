// Copyright 2015 theaigames.com (developers@theaigames.com)

//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at

//        http://www.apache.org/licenses/LICENSE-2.0

//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//	
//    For the full copyright and license information, please view the LICENSE
//    file that was distributed with this source code.

package bot;

import field.Field;
import field.ShapeType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.awt.Point;

import moves.MoveType;

/**
 * BotStarter class
 * 
 * This class is where the main logic should be. Implement getMoves() to
 * return something better than random moves.
 * 
 * @author Jim van Eeden <jim@starapple.nl>
 */

public class BotStarter {

	public BotStarter() {}
	
	/**
	 * Will eventually return the set of moves that sends the current shape 
         * to the most optimal position based on the next shape and several metrics
	 * @param state : current state of the bot
	 * @param timeout : time to respond
	 * @return : a list of moves to execute
	 */
	public ArrayList<MoveType> getMoves(BotState state, long timeout) {
		
                Field cField = state.getMyField();
                ShapeType cShape = state.getCurrentShape();
                ShapeType nShape = state.getNextShape();
                ArrayList<MoveType> moves = new ArrayList<MoveType>();
                
                //the position of a shape is stored as a Point, not sure what Points are in java exactly will investigate
                ArrayList<Point> cPos = getPos(cField, cShape);
                ArrayList<Field> cFields = genFields(cField, cPos);
                
                ArrayList<Point> nPos;
                ArrayList<ArrayList<Field>> nFields = null; //2D arraylist, syntax might be off
                for (Field f : cFields) {
                    nPos = getPos(f, nShape);
                    nFields.add(genFields(f, nPos));
                }
                
                /*at this point we'll have a 2D array of every possible field for the current and next shape that won't
                have trapped empty spaces, next we'll need to do 2 things:
                
                1. compare them all and choose the best position based on the metrics system we create (this is what treeSearch() is for)
                
                2. convert the best position into move instructions to store in moves and return*/
                
                

		
		return moves;
	}
	
        /**
         * Returns all shape positions that don't have empty spaces underneath in an ArrayList
         * @param field : any given field
         * @param shape : any given shape
         * @return : list of positions for the ShapeType to be in on the field that don't create trapped empty cells
         */
        public ArrayList<Point> getPos(Field field, ShapeType shape)
        {
            ArrayList<Point> pos = new ArrayList<Point>();
            return pos;
        }
        
        /**
         * Returns all fields (board layouts) for a given ArrayList of positions
         * @param field : any given field
         * @param pos : any given ArrayList of positions (points)
         * @return : an ArrayList with a generated field for each given position 
         */
        public ArrayList<Field> genFields(Field field, ArrayList<Point> pos)
        {
            ArrayList<Field> fields = new ArrayList<Field>();
            return fields;
        }
        
        /**
         * searches the tree and finds the best position to use according to height 
         * and potential block placement metrics
         * @param Fields : the 2d ArrayList that is the tree
         * @return the most optimal position
         */
        public Point treeSearch(ArrayList<ArrayList<Field>> Fields)
        {
            Point bestPos = new Point();
            return bestPos; 
        }
        
	public static void main(String[] args)
	{
		BotParser parser = new BotParser(new BotStarter());
		parser.run();
	}
}
