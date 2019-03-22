package View;

import Controller.Controller;
import Model.ProgramState;

import java.util.List;
import java.util.Scanner;

public class RunCommand extends Command {
    private Controller ctr;
    public RunCommand(String key, String desc, Controller ctr){
        super(key, desc);
        this.ctr=ctr;
    }
    @Override
    public void execute() throws InterruptedException {
        System.out.println("Input the option: ");
        System.out.println("1. all steps ");
        System.out.println("2. one step at a time ");
        Scanner reader = new Scanner(System.in);
        String cm = reader.nextLine();
        switch (cm) {
            case "1":
                ctr.allSteps(0, false);
            case "2":
                fancyexe();

        }

    }

    private void fancyexe() throws InterruptedException {
        ctr.fancyexehelp1();
        List<ProgramState> lp=ctr.getPrograms();
        while (lp.size()>0) {
            System.out.println("1. next ");
            System.out.println("2. stop ");
            Scanner reader = new Scanner(System.in);
            String cm = reader.nextLine();
            if(cm.equals("1")) {
                lp.forEach(ps ->
                        ps.getHeap().set(ctr.conservativeGarbageCollector(
                                ps.getSymTable().getContent().values(),
                                ps.getHeap().getDict())));
                ctr.oneStepForAllPrg(lp);
                for (ProgramState prg : lp) {
                    System.out.println(prg.toString());
                }
                lp=ctr.removeCompletedPrg(ctr.getPrograms());
            }
            else break;
            }

        ctr.fancyexehelp2(ctr.getPrograms());

    }

}
