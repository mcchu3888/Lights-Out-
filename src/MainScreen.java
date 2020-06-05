/*
** Class Description: Main class and main frame for lights out. Initializes the screen and all of its components.
** Name: Michael Chu
** Period: 3
** Date: 5/29/20
** Version: 1
 */
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.*;

public class MainScreen extends javax.swing.JDialog {

    /**
     * Creates new form MainScreen
     */
    public MainScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * produced by net beans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameScreen = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        moveCounter = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        instructions = new javax.swing.JMenuItem();
        resetGame = new javax.swing.JMenuItem();
        exitGame = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        gamemode = new javax.swing.JMenu();
        selfPlay = new javax.swing.JMenuItem();
        AI = new javax.swing.JMenuItem();
        boardSize = new javax.swing.JMenu();
        new3x3 = new javax.swing.JMenuItem();
        new5x5 = new javax.swing.JMenuItem();
        new10x10 = new javax.swing.JMenuItem();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        gameScreen.setBackground(new java.awt.Color(250, 250, 250));
        gameScreen.setPreferredSize(new java.awt.Dimension(401, 401));
        gameScreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameScreenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout gameScreenLayout = new javax.swing.GroupLayout(gameScreen);
        gameScreen.setLayout(gameScreenLayout);
        gameScreenLayout.setHorizontalGroup(
            gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        gameScreenLayout.setVerticalGroup(
            gameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Lights Out Puzzle");

        moveCounter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        moveCounter.setText("Moves: 0");
        moveCounter.setToolTipText("");

        file.setText("File");

        instructions.setText("instructions");
        instructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructionsActionPerformed(evt);
            }
        });
        file.add(instructions);

        resetGame.setText("reset");
        resetGame.setToolTipText("");
        resetGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetGameActionPerformed(evt);
            }
        });
        file.add(resetGame);

        exitGame.setText("exit");
        exitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGameActionPerformed(evt);
            }
        });
        file.add(exitGame);

        jMenuBar1.add(file);

        edit.setText("Edit");

        gamemode.setText("gamemode");

        selfPlay.setText("self play");
        selfPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selfPlayActionPerformed(evt);
            }
        });
        gamemode.add(selfPlay);

        AI.setText("AI");
        AI.setToolTipText("");
        AI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AIActionPerformed(evt);
            }
        });
        gamemode.add(AI);

        edit.add(gamemode);

        boardSize.setText("board size");

        new3x3.setText("3 x 3");
        new3x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new3x3ActionPerformed(evt);
            }
        });
        boardSize.add(new3x3);

        new5x5.setText("5 x 5");
        new5x5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new5x5ActionPerformed(evt);
            }
        });
        boardSize.add(new5x5);

        new10x10.setText("10 x 10");
        new10x10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new10x10ActionPerformed(evt);
            }
        });
        boardSize.add(new10x10);

        edit.add(boardSize);

        jMenuBar1.add(edit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moveCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(gameScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gameScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(moveCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //if user clicks exit in the menu bar, the screen closes/program ends
    private void exitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGameActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitGameActionPerformed

    //if the user clicks a square on the board, the corresponding move will be made and the board will be painted apporpiately 
    private void gameScreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameScreenMouseClicked
        // TODO add your handling code here:
        int xpos = evt.getX();
        int ypos = evt.getY();
        int squareSize = board.getSquareSize();
        
        int row = (int)(ypos/squareSize);
        int col = (int)(xpos/squareSize);
        
        board.move(row,col);
        counter++;
    
        if(cheater)
        {
            if(ai.get(row,col) == 0)
                ai = new AI(board);
            else
                ai.set(row, col, 0);
        }
        
        drawBoard();
        
         if(board.isWinningMove())
        {
            if(!cheater)
                JOptionPane.showMessageDialog(null, "Congrats! You solved the puzzle!\nMoves made: " + counter);
            else
                JOptionPane.showMessageDialog(null, "Congrats! You cheated! Now go back and solve the puzzle by yourself.\nMoves made: " + counter);
        }
    }//GEN-LAST:event_gameScreenMouseClicked
    
    //if the user clicks reset in the menu, the game resets to a random standard 5x5 lights out puzzle
    private void resetGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetGameActionPerformed
        // TODO add your handling code here:
        newGame(5,5);
    }//GEN-LAST:event_resetGameActionPerformed

    //on launch of the game, a new, random standard 5x5 lights out puzzle will be created 
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        newGame(5,5);
    }//GEN-LAST:event_formWindowOpened
    
    //if the user clicks 3x3 in the menu, the game resizes to a random 3x3 lights out puzzle
    private void new3x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new3x3ActionPerformed
        // TODO add your handling code here:
        newGame(3,3);
    }//GEN-LAST:event_new3x3ActionPerformed

    //if the user clicks 3x3 in the menu, the game resizes to a random 5x5 lights out puzzle
    private void new5x5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new5x5ActionPerformed
        // TODO add your handling code here:
        newGame(5,5);
    }//GEN-LAST:event_new5x5ActionPerformed

    //if the user clicks 3x3 in the menu, the game resizes to a random 5x5 lights out puzzle
    private void new10x10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new10x10ActionPerformed
        // TODO add your handling code here:
        newGame(10,10);
    }//GEN-LAST:event_new10x10ActionPerformed

    //if the user decides the puzzle is too hard for them, they can choose to be a cheater and get a solution. Don't worry, they will be rediculed for chosing this option.
    private void AIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AIActionPerformed
        // TODO add your handling code here:
        cheater = true;
        ai = new AI(board);
        int[][]solution = ai.getSolution();
        for(int i = 0; i < solution.length; i++)
        {
            for(int j = 0; j < solution[0].length; j++)
            {
                System.out.print(solution[i][j]);
            }
            System.out.println();
        }
        drawBoard();
    }//GEN-LAST:event_AIActionPerformed

    //if the user clicks self play in the menu, the solution will be removed and the user can go back to solving the puzzle by themself 
    private void selfPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selfPlayActionPerformed
        // TODO add your handling code here:
        cheater = false;
        drawBoard();
    }//GEN-LAST:event_selfPlayActionPerformed

    //if the user clicks instructions, they will be able to view the description/instructions for the puzzle
    private void instructionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionsActionPerformed
        // TODO add your handling code here:
       Instructions instruct = new Instructions(new JFrame(), true);
       instruct.setVisible(true);
    }//GEN-LAST:event_instructionsActionPerformed
    
    //creates a new, random lights out puzzle for a given board size
    public void newGame(int rows, int cols)
    {
       board = new Board(rows, cols);
       counter = 0;
       cheater = false;
       drawBoard();
    }
    
    //paints/prints the board and counter at their current state onto the panel for the user to view
    public void drawBoard()
    {  
       Graphics2D gfx = (Graphics2D) gameScreen.getGraphics();
       gfx.clearRect(0,0,401,401);
       int squareSize = board.getSquareSize();
       
       for(int r = 0; r < board.getNumOfRows()+1; r++)
           gfx.drawLine(0, r*squareSize, 401, r*squareSize);
  
       for(int c = 0; c < board.getNumOfCols()+1; c++)
           gfx.drawLine(c*squareSize, 0, c*squareSize, 401);
       
       for(int i = 0; i < board.getNumOfRows(); i++)
       {
           for(int j = 0; j < board.getNumOfCols(); j++)
           {
               if(board.getSquare(i,j).getColor() == 0)
               {
                   gfx.setColor(Color.WHITE);
                   gfx.fillRect(j*squareSize+1, i*squareSize+1, squareSize-1, squareSize-1);
               }
               else 
               {
                   gfx.setColor(Color.GRAY);
                   gfx.fillRect(j*squareSize+1, i*squareSize+1, squareSize-1, squareSize-1);
               }
           }
       }
       
       if(cheater)
           drawSolution();
       
       moveCounter.setText("Moves: " + counter);
    }
    
    //prints the program calculated solution for the user to follow/copy
    public void drawSolution()
    {
        Graphics2D gfx = (Graphics2D) gameScreen.getGraphics();
        int squareSize = board.getSquareSize();
        int circleSize = squareSize/4;
        
        gfx.setColor(Color.red);
        
        for(int i = 0; i < board.getNumOfRows(); i++)
        {
           for(int j = 0; j < board.getNumOfCols(); j++)
           {
               if(ai.get(i,j) == 1)
                   gfx.fillOval(j*squareSize + (int)(1.5*circleSize), i*squareSize + (int)(1.5*circleSize), circleSize, circleSize);
           }
        }
    }
    
    /**
     * main/run, displays the GUI
     * produced by net beans
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainScreen dialog = new MainScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AI;
    private javax.swing.JMenu boardSize;
    private javax.swing.JMenu edit;
    private javax.swing.JMenuItem exitGame;
    private javax.swing.JMenu file;
    private javax.swing.JPanel gameScreen;
    private javax.swing.JMenu gamemode;
    private javax.swing.JMenuItem instructions;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel moveCounter;
    private javax.swing.JMenuItem new10x10;
    private javax.swing.JMenuItem new3x3;
    private javax.swing.JMenuItem new5x5;
    private javax.swing.JMenuItem resetGame;
    private javax.swing.JMenuItem selfPlay;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
private Board board;
private int counter = 0;
private boolean cheater = false;
private AI ai;

}
