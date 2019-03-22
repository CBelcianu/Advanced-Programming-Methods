package View;

import Controller.Controller;
import Exceptions.DivisionByZeroException;
import Exceptions.InvalidOperationException;
import Exceptions.UndefinedVariableException;
import Model.ExecutionStack;
import Model.ProgramState;
import Model.Statements.IStatement;

import java.util.Scanner;

public class View {
    private Controller ctrl;

    public View(Controller ctrl) {
        this.ctrl = ctrl;
    }

    private static void printMenu() {
        System.out.println("\n1. Run a program");
        System.out.println("2. Run a program one step at a time");
        System.out.println("0. Exit\n");
    }

    private static void printPrograms() {
        System.out.println("\n\t\t CHOOSE A PROGRAM");
        System.out.println("1. v=2; Print(v)");
        System.out.println("2. a=2+3*5; b=a+1; Print(b)");
        System.out.println("3. a=2-2; If a Then v=2 Else v=3; Print(v)");
        System.out.println(("4. a=2; d=5/0; Print(d)"));
        System.out.println(("5. a=2; d=5*1; Print(e)"));
        System.out.println("6.afas");
        System.out.println("0. Back\n");
    }

    private static void printOneStepMenu(){
        System.out.println("1.Next Step");
        System.out.println("0.Stop Evaluation\n");
    }

    public void start() throws InterruptedException {
        boolean running = true;
        int command, index = 0;
        Scanner reader = new Scanner(System.in);
        System.out.println("\nApplication started");
        System.out.print("\nEnter the path to the log file: ");
        String filepath = reader.nextLine();
        ctrl.setRepoFilepath(filepath);
        while (running) {
            printMenu();
            System.out.print(">> ");
            command = reader.nextInt();
            switch (command) {

                case 0:
                    running = false;
                    System.out.println("\nTerminating...\n");
                    break;

                case 1:
                    printPrograms();
                    System.out.print(">> ");
                    index = reader.nextInt();
                    System.out.println();
                    if (index == 0) break;
                    ctrl.allSteps(index-1,false);
                    break;
                case 2:
                    printPrograms();
                    System.out.println(">> ");
                    index=reader.nextInt();
                    System.out.println();
                    if(index==0) break;
                    ProgramState ps = ctrl.getProgramStateCtrl(index-1);
                    ExecutionStack<IStatement> es = ps.getExecutionStack();
                    System.out.println(ps.toString());
                    while(!es.isEmpty()){
                        printOneStepMenu();
                        System.out.println(">> ");
                        int commandOneStep = reader.nextInt();
                        if(commandOneStep==1)
                            try {
                                ctrl.oneStep(ps, es, true);
                            }
                            catch(DivisionByZeroException | InvalidOperationException | UndefinedVariableException exc){
                                System.out.println(exc.getMessage());
                                break;
                            }
                        else
                            break;
                    }
                    break;
            }
        }
    }
}
