package com.cwt.io;

import com.cwt.system.jslix.KeyPress;

/**
 * KeyControl.java
 *
 * A basic class for dealing with a small subset of predefined keys
 * This is meant to combine the Control and ID class into one
 * function.
 *
 * @author <ul><li>Carr, Crecen</li>
 *              <li>Radom, Alexander</li></ul>
 * @license Look into "LICENSE" file for further information
 * @version 10.28.10
 */
public class KeyControl {
    /*
     * Keyboard values
     */
    public static enum Keys{
        // action keys with values for keyboard keys
        UP(200, 38), DOWN(208, 40),
        LEFT(203, 37), RIGHT(205, 39), 
        SELECT(44, 90),CANCEL(45, 88);

        // key value of the key
        private int slick;
        private int java;

        Keys(int slickVal, int javaVal){
            slick = slickVal;
            java = javaVal;
        }

        // Access Methods
        public int javaValue(){
            return java;
        }
        public int slickValue(){
            return slick;
        }
        public void setValues(int slick, int java){
            this.java = java;
            this.slick = slick;
        }
    }

    /**
     * Mouse values
     */
    public static enum Mouse{

        //action clicks with clicks for the mouse
        SELECT(0, 1), CANCEL(1, 3);

        private int slick;
        private int java;

        Mouse(int slickVal, int javaVal){
            slick = slickVal;
            java = javaVal;
        }

        // Access Methods
        public int javaValue(){
            return java;
        }
        public int slickValue(){
            return slick;
        }
        public void setValues(int slick, int java){
            this.java = java;
            this.slick = slick;
        }
    }

    /**
     * This function checks to see if the user is actively pressing something
     * @return if a user a pressing an action(true) or not(false)
     */
    public static boolean isUserActive(){
        return KeyPress.userActive();
    }

    /**
     * This function tells you if the last action pressed was a mouse action
     * @return if the user pressed the mouse action last
     */
    public static boolean isMouseFocused(){
        return KeyPress.mouseFocused();
    }

    /**
     * This function gets the last key pressed by the user
     * @return The last key pressed
     */
    public static int getLastKey(){
        return KeyPress.lastKeyAction();
    }

    /**
     * This function gets the last mouse click done by the user
     * @return The last mouse click
     */
    public static int getLastMouse(){
        return KeyPress.lastMouseAction();
    }

    /**
     * This function converts Slick keys into Java keys and vice versa
     * depending on the window that is displayed
     * @param keycode The current key code to convert
     * @return A key code opposite to the window displayed
     */
    public static int getKeyConversion(int keycode){
        return KeyPress.getKeyConversion(keycode);
    }

    /**
     * Polls to see whether this is a Slick Window
     * @return whither this is a Slick Window (true) or a Java window (false)
     */
    public static boolean isSlickWindow(){
        return KeyPress.isSlickWindow();
    }

    /**
     * Is a button clicked ?
     */
    private static boolean isClicked( Keys key ){
        return KeyPress.isKeyPressed(KeyPress.isSlickWindow() ?
            key.slickValue() : key.javaValue());
    }

    /**
     * Is a button hold ?
     */
    private static boolean isDown( Keys key ){
        return KeyPress.isKeyDown(KeyPress.isSlickWindow() ?
            key.slickValue() : key.javaValue());
    }

    /**
     * Is a mouse button clicked ?
     */
    private static boolean isClicked( Mouse mouse ){
        return KeyPress.isMouseClicked(KeyPress.isSlickWindow() ?
            mouse.slickValue() : mouse.javaValue());
    }

    /**
     * Is a mouse button hold ?
     */
    private static boolean isDown( Mouse mouse ){
        return KeyPress.isMouseDown(KeyPress.isSlickWindow() ?
            mouse.slickValue() : mouse.javaValue());
    }

    /*
     * DIRECT ACCESS METHODS
     * *********************
     */
    
    // MOUSE LOCATION
    public static int getMouseX(){
    	return KeyPress.getMouseX();	}
    public static int getMouseY(){
    	return KeyPress.getMouseY();	}
    public static void resetMouseWheel(){
    	KeyPress.resetMouseWheel();     }

    // IS CLICKED
    public static boolean isUpClicked(){
        return isClicked( Keys.UP ); }
    public static boolean isDownClicked(){
        return isClicked( Keys.DOWN ); }
    public static boolean isLeftClicked(){
        return isClicked( Keys.LEFT ); }
    public static boolean isRightClicked(){
        return isClicked( Keys.RIGHT ); }
    public static boolean isActionClicked(){
        return (isClicked( Keys.SELECT ) || isClicked( Mouse.SELECT )); }
    public static boolean isCancelClicked(){
        return (isClicked( Keys.CANCEL ) || isClicked( Mouse.CANCEL )); }

    // IS DOWN
    public static boolean isUpDown(){
        return isDown( Keys.UP ); }
    public static boolean isDownDown(){
        return isDown( Keys.DOWN ); }
    public static boolean isLeftDown(){
        return isDown( Keys.LEFT ); }
    public static boolean isRightDown(){
        return isDown( Keys.RIGHT ); }
    public static boolean isActionDown(){
        return (isDown( Keys.SELECT ) || isDown( Mouse.SELECT)); }
    public static boolean isCancelDown(){
        return (isDown( Keys.CANCEL ) || isDown( Mouse.CANCEL )); }
}
