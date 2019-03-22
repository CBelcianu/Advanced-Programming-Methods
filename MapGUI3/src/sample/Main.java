package sample;

import Model.Statements.*;
import Model.expressions.ArithmeticExpression;
import Model.expressions.ConstantExpression;
import Model.expressions.VariableExpression;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.*;
import Controller.Controller;
import Repository.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.chrono.IsoChronology;
import java.util.List;
import java.util.Map;

public class Main extends Application {
    private Stage window;
    private Scene s1, s2;
    private Controller selectedCtrl;
    private ObservableList<Controller> programs;
    private ListView<String> programsStrings;
    private TextField programsNumber;
    private TableView<HeapPair> heap;
    private TableView<TablePair> filetable;
    private TableView<TablePair> symTable;
    private ListView<String> stack;
    private ListView<String> output;
    private ListView<String> programStates;
    private Label fileTableLabel = new Label();
    private Label heapLabel = new Label();
    private Label symTableLabel = new Label();
    private Label stackLabel = new Label();
    private Label outputLabel = new Label();
    private Label programStatesLabel = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception{
        IStatement ex1=new CompoundStatement(
                new AssignStatement(
                        "v",
                        new ConstantExpression(2)
                ),
                new PrintStatement(
                        new VariableExpression("v")
                )
        );

        String fp="C:\\Users\\Catalin\\Desktop\\#WORK\\anul2\\MAP\\MapGUI3\\log.txt";

        IRepository repo1 = new Repository();
        Controller ctrl1 = new Controller(repo1);
        ctrl1.load(new ProgramState(new ExecutionStack<>(ex1), new SymbolTable<>(), new Output<>(), ex1, new FileTable(), new Heap(),1));
        ctrl1.setOriginalProgram(ex1.toString());
        ctrl1.setRepoFilepath(fp);

        IStatement ex2 = new CompoundStatement(
                new AssignStatement(
                        "a",
                        new ArithmeticExpression(
                                new ConstantExpression(2),
                                '*',
                                new ArithmeticExpression(
                                        new ConstantExpression(3),
                                        '*',
                                        new ConstantExpression(5)
                                )
                        )
                ),
                new CompoundStatement(
                        new AssignStatement(
                                "b",
                                new ArithmeticExpression(
                                        new VariableExpression("a"),
                                        '+',
                                        new ConstantExpression(1)
                                )
                        ),
                        new PrintStatement(
                                new VariableExpression("b")
                        )
                )
        );

        IRepository repo2 = new Repository();
        Controller ctrl2 = new Controller(repo2);
        ctrl2.load(new ProgramState(new ExecutionStack<>(ex2), new SymbolTable<>(), new Output<>(), ex2, new FileTable(), new Heap(),1));
        ctrl2.setOriginalProgram(ex2.toString());
        ctrl2.setRepoFilepath(fp);

        // a=2-2; If a Then v=2 Else v=3; Print(v)
        IStatement ex3 = new CompoundStatement(
                new AssignStatement(
                        "a",
                        new ArithmeticExpression(
                                new ConstantExpression(2),
                                '-',
                                new ConstantExpression(2)
                        )
                ),
                new CompoundStatement(
                        new IfStatement(
                                new VariableExpression("a"),
                                new AssignStatement(
                                        "v",
                                        new ConstantExpression(2)
                                ),
                                new AssignStatement(
                                        "v",
                                        new ConstantExpression(3)
                                )
                        ),
                        new PrintStatement(
                                new VariableExpression("v")
                        )
                )
        );

        //load the program
        IRepository repo3 = new Repository();
        Controller ctrl3 = new Controller(repo3);
        ctrl3.load(new ProgramState(new ExecutionStack<>(ex3), new SymbolTable<>(), new Output<>(), ex3,new FileTable(),new Heap(),1));
        ctrl3.setOriginalProgram(ex3.toString());
        ctrl3.setRepoFilepath(fp);


        IStatement ex4=new CompoundStatement(
                new AssignStatement(
                        "v",
                        new ConstantExpression(6)
                ),
                new CompoundStatement(
                        new WhileStatement(
                                new ArithmeticExpression(
                                        new VariableExpression("v"),
                                        '-',
                                        new ConstantExpression(4)
                                ),
                                new CompoundStatement(
                                        new PrintStatement(
                                                new VariableExpression("v")
                                        ),
                                        new AssignStatement(
                                                "v",
                                                new ArithmeticExpression(
                                                        new VariableExpression("v"),
                                                        '-',
                                                        new ConstantExpression(1)
                                                )
                                        )
                                )
                        ),
                        new PrintStatement(
                                new VariableExpression("v")
                        )
                )
        );

        IRepository repo4 = new Repository();
        Controller ctrl4 = new Controller(repo4);
        ctrl4.load(new ProgramState(new ExecutionStack<>(ex4), new SymbolTable<>(), new Output<>(), ex4,new FileTable(),new Heap(),1));
        ctrl4.setOriginalProgram(ex4.toString());
        ctrl4.setRepoFilepath(fp);


        IStatement ex5 = new CompoundStatement(
                new AssignStatement(
                        "v",
                        new ConstantExpression(20)
                ),
                new CompoundStatement(
                        new forStatement(
                                new forkStatement(
                                        new CompoundStatement(
                                                new PrintStatement( new VariableExpression("v")),
                                                new AssignStatement(
                                                        "v",
                                                        new ArithmeticExpression(
                                                                new VariableExpression("v"),
                                                                '+',
                                                                new ConstantExpression(1)
                                                        )
                                                )
                                        )
                                ),
                                new ConstantExpression(0),
                                new ConstantExpression(3),
                                new ArithmeticExpression(
                                        new VariableExpression("v"),
                                        '+',
                                        new ConstantExpression(1)
                                ),
                                "v"
                        ),
                        new PrintStatement(
                                new ArithmeticExpression(
                                        new VariableExpression("v"),
                                        '*',
                                        new ConstantExpression(10)
                                )
                        )
                )
        );

        IRepository repo5 = new Repository();
        Controller ctrl5 = new Controller(repo5);
        ctrl5.load(new ProgramState(new ExecutionStack<>(ex5), new SymbolTable<>(), new Output<>(), ex5,new FileTable(),new Heap(),1));
        ctrl5.setOriginalProgram(ex5.toString());
        ctrl5.setRepoFilepath(fp);

        IStatement ex6 = new CompoundStatement(
                new AssignStatement(
                        "v",
                        new ConstantExpression(10)
                ),
                new CompoundStatement(
                        new newStatement(
                                "v",
                                new ConstantExpression(20)
                        ),
                        new CompoundStatement(
                                new newStatement(
                                        "a",
                                        new ConstantExpression(22)
                                ),
                                new CompoundStatement(
                                        new wH(
                                                "a",
                                                new ConstantExpression(30)
                                        ),
                                        new CompoundStatement(
                                                new PrintStatement(
                                                        new VariableExpression("a")
                                                ),
                                                new PrintStatement(
                                                        new rH("a")
                                                )
                                        )
                                )
                        )
                )
        );

        IRepository repo6 = new Repository();
        Controller ctrl6 = new Controller(repo6);
        ctrl6.load(new ProgramState(new ExecutionStack<>(ex6), new SymbolTable<>(), new Output<>(), ex6,new FileTable(),new Heap(),1));
        ctrl6.setOriginalProgram(ex6.toString());
        ctrl6.setRepoFilepath(fp);

        IStatement ex7 = new CompoundStatement(
                new AssignStatement(
                        "v",
                        new ConstantExpression(20)
                ),
                new doWhileStatement(
                        new CompoundStatement(
                                new PrintStatement(
                                        new VariableExpression("v")
                                ),
                                new AssignStatement(
                                        "v",
                                        new ArithmeticExpression(
                                                new VariableExpression("v"),
                                                '-',
                                                new ConstantExpression(1)
                                        )
                                )
                        ),
                        new ArithmeticExpression(
                                new VariableExpression("v"),
                                '-',
                                new ConstantExpression(10)
                        )
                )
        );

        IRepository repo7 = new Repository();
        Controller ctrl7 = new Controller(repo7);
        ctrl7.load(new ProgramState(new ExecutionStack<>(ex7), new SymbolTable<>(), new Output<>(), ex7,new FileTable(),new Heap(),1));
        ctrl7.setOriginalProgram(ex7.toString());
        ctrl7.setRepoFilepath(fp);

        IStatement ex8=new CompoundStatement(
                new AssignStatement("a",new ConstantExpression(1)),
                new CompoundStatement(
                        new AssignStatement("b",new ConstantExpression(2)),
                        new CompoundStatement(
                                new condAssignStatement("c",new VariableExpression("a"),new ConstantExpression(100),new ConstantExpression(200)),
                                new CompoundStatement(
                                        new PrintStatement(new VariableExpression("c")),
                                        new CompoundStatement(
                                                new condAssignStatement("c",new ArithmeticExpression(new VariableExpression("b"),'-',new ConstantExpression(2)),new ConstantExpression(100),new ConstantExpression(200)),
                                                new PrintStatement(new VariableExpression("c"))
                                        )
                                )
                        )
                )
        );

        IRepository repo8 = new Repository();
        Controller ctrl8 = new Controller(repo8);
        ctrl8.load(new ProgramState(new ExecutionStack<>(ex8), new SymbolTable<>(), new Output<>(), ex8,new FileTable(),new Heap(),1));
        ctrl8.setOriginalProgram(ex8.toString());
        ctrl8.setRepoFilepath(fp);

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("A8");

        //initial configuration
        programsStrings = new ListView<>();

        programs = FXCollections.observableArrayList();
        programs.addAll(ctrl8);

        for (Controller c: programs) {
            programsStrings.getItems().add(c.getOriginalProgram());
        }

        window = primaryStage;

        //configure scene1
        Button forth = new Button();
        forth.setText("Run program");

        VBox layout1 = new VBox();
        layout1.getChildren().addAll(programsStrings, forth);

        s1 = new Scene(layout1, 500, 500);

        //configure scene2
        heapLabel.setText("Heap");
        fileTableLabel.setText("File Table");
        symTableLabel.setText("Symbol Table");

        //configure heap table
        heap = new TableView<>();

        TableColumn<HeapPair, Integer> columnHeapAddress = new TableColumn<>("Address");
        columnHeapAddress.setMinWidth(50);
        columnHeapAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<HeapPair, Integer> columnHeapValue = new TableColumn<>("Value");
        columnHeapValue.setMinWidth(50);
        columnHeapValue.setCellValueFactory(new PropertyValueFactory<>("value"));

        heap.getColumns().addAll(columnHeapAddress, columnHeapValue);

        //configure symbol table
        symTable = new TableView<>();

        TableColumn<TablePair, String> columnSymTableVariable = new TableColumn<>("Variable");
        columnSymTableVariable.setMinWidth(50);
        columnSymTableVariable.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<TablePair, Integer> columnSymTableValue = new TableColumn<>("Value");
        columnSymTableValue.setMinWidth(50);
        columnSymTableValue.setCellValueFactory(new PropertyValueFactory<>("number"));

        symTable.getColumns().addAll(columnSymTableVariable, columnSymTableValue);

        //configure file table
        filetable = new TableView<>();

        TableColumn<TablePair, String> columnFileTableIdentifier = new TableColumn<>("Identifier");
        columnFileTableIdentifier.setMinWidth(50);
        columnFileTableIdentifier.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<TablePair, Integer> columnFileTableFileName = new TableColumn<>("File name");
        columnFileTableFileName.setMinWidth(50);
        columnFileTableFileName.setCellValueFactory(new PropertyValueFactory<>("name"));

        filetable.getColumns().addAll(columnFileTableIdentifier, columnFileTableFileName);

        //configure exeStack
        stack = new ListView<>();
        stackLabel.setText("Execution Stack");

        //configure outQueue
        output = new ListView<>();
        outputLabel.setText("Output Queue");

        programStates = new ListView<>();
        programStatesLabel.setText("Program States");

        programsNumber = new TextField();

        Button step = new Button();
        step.setText("One Step");

        Button back = new Button();
        back.setText("Back");

        VBox layout2 = new VBox();
        layout2.setMaxSize(100,100);
        layout2.getChildren().addAll(programsNumber,stackLabel,stack,programStatesLabel,programStates,heapLabel,heap,symTableLabel,symTable,fileTableLabel,filetable,outputLabel,output,step,back);

        s2 = new Scene(layout2, 400, 600);

        forth.setOnAction(actionEvent -> runProgramButton());
        step.setOnAction(actionEvent -> {
            try {
                runOneStepButton();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        back.setOnAction(actionEvent -> window.setScene(s1));
        programStates.setOnMouseClicked(actionEvent -> setProgramState());

        window.setScene(s1);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void runProgramButton(){
        window.setScene(s2);
        filetable.getItems().clear();
        symTable.getItems().clear();
        heap.getItems().clear();
        stack.getItems().clear();
        output.getItems().clear();
        programStates.getItems().clear();
        selectedCtrl = getSelectedController();
        if(selectedCtrl == null)
            AlertBox.display("Warning","No program selected!");
        else {
            if (selectedCtrl.getRepo().getProgramList().size() == 0)
                AlertBox.display("Warning", "This program was already executed!");
            else {
                IRepository r = selectedCtrl.getRepo();
                IStack<IStatement> exeStack = r.getProgramList().get(0).getExecutionStack();
                IStack<IStatement> stack2 = new ExecutionStack<>();
                while (!exeStack.isEmpty()) {
                    IStatement stmt = exeStack.pop();
                    stack.getItems().add(stmt.toString());
                    stack2.push(stmt);
                }
                while (!stack2.isEmpty()) {
                    exeStack.push(stack2.pop());
                }
                for (ProgramState ps : r.getProgramList())
                    programStates.getItems().add(ps.toString());

                programsNumber.setText(String.valueOf(r.getProgramList().get(0).getID()));
            }
        }
    }

    private Controller getSelectedController(){
        for(Controller c: programs) {
            if(c.getOriginalProgram().equals(programsStrings.getSelectionModel().getSelectedItem()))
                return c;
        }
        return null;
    }

    private void runOneStepButton() throws InterruptedException {
        List<ProgramState> prgList = selectedCtrl.removeCompletedPrg(selectedCtrl.getRepo().getProgramList());
        prgList.forEach(prg->selectedCtrl.getRepo().logPrgState(prg));
        if(prgList.size() > 0){
            selectedCtrl.oneStepForAllPrg(prgList);
            boolean ok = true;
            for(ProgramState p: prgList){
                Map<Integer, Integer> m = selectedCtrl.conservativeGarbageCollector(p.getSymTable().getContent().values(), p.getHeap().getDict());
                if(p.getHeap().getDict().size() == m.size()) {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                prgList.forEach(p -> {
                    Map<Integer, Integer> m = selectedCtrl.conservativeGarbageCollector(p.getSymTable().getContent().values(), p.getHeap().getDict());
                    p.getHeap().clear();
                    p.getHeap().set(m);
                });
            }

            filetable.getItems().clear();
            symTable.getItems().clear();
            heap.getItems().clear();
            stack.getItems().clear();
            output.getItems().clear();
            programStates.getItems().clear();

            IRepository r = selectedCtrl.getRepo();
            IStack<IStatement> exeStack = r.getProgramList().get(0).getExecutionStack();
            IStack<IStatement> stack2 = new ExecutionStack<>();
            while(!exeStack.isEmpty()){
                IStatement stmt = exeStack.pop();
                stack.getItems().add(stmt.toString());
                stack2.push(stmt);
            }

            while(!stack2.isEmpty()){
                exeStack.push(stack2.pop());
            }

            IList<Integer> out = r.getProgramList().get(0).getOutput();
            IList<Integer> out2 = new Output<>();
            while(!out.isEmpty()){
                int s = out.pop();
                output.getItems().add(String.valueOf(s));
                out2.add(s);
            }

            while(!out2.isEmpty()){
                out.add(out2.pop());
            }

            for(ProgramState ps : r.getProgramList())
                programStates.getItems().add(ps.toString());

            ObservableList<HeapPair> hps = FXCollections.observableArrayList();
            for(int key : r.getProgramList().get(0).getHeap().getKeys()){
                hps.add(new HeapPair(key, r.getProgramList().get(0).getHeap().get(key)));
            }
            heap.setItems(hps);

            ObservableList<TablePair> sts = FXCollections.observableArrayList();
            for(String key : r.getProgramList().get(0).getSymTable().getContent().keySet()){
                sts.add(new TablePair(r.getProgramList().get(0).getSymTable().get(key), key));
            }

            symTable.setItems(sts);

            ObservableList<TablePair> fts = FXCollections.observableArrayList();
            for(int key : r.getProgramList().get(0).getFileTable().getContent().keySet()){
                fts.add(new TablePair(key, r.getProgramList().get(0).getFileTable().get(key).getKey()));
            }
            filetable.setItems(fts);

            prgList = selectedCtrl.removeCompletedPrg(selectedCtrl.getRepo().getProgramList());

            if(prgList.size() == 0){
                selectedCtrl.getExecutor().shutdownNow();
                selectedCtrl.getRepo().getProgramList().get(0).getFileTable().entrySet().forEach(k -> {
                    try {
                        k.getValue().getValue().close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                selectedCtrl.getRepo().getProgramList().get(0).getFileTable().clear();
                selectedCtrl.getRepo().getProgramList().forEach(prg -> selectedCtrl.getRepo().logPrgState(prg));
                selectedCtrl.getRepo().setProgramList(prgList);
            }
            selectedCtrl.getRepo().setProgramList(prgList);
        }
        else {
            AlertBox.display("Warning", "Program is finished!");
        }
    }

    private ProgramState getSelectedPrgState(){
        for(ProgramState p: selectedCtrl.getRepo().getProgramList()) {
            if(p.toString().equals(programStates.getSelectionModel().getSelectedItem()))
                return p;
        }
        return null;
    }

    private void setProgramState(){
        if(getSelectedPrgState() == null)
            AlertBox.display("Error", "The thread already finished!");
        else {
            programsNumber.setText(String.valueOf(getSelectedPrgState().getID()));

            filetable.getItems().clear();
            symTable.getItems().clear();
            heap.getItems().clear();
            stack.getItems().clear();
            output.getItems().clear();

            IStack<IStatement> exeStack = getSelectedPrgState().getExecutionStack();
            IStack<IStatement> stack2 = new ExecutionStack<>();
            while (!exeStack.isEmpty()) {
                IStatement stmt = exeStack.pop();
                stack.getItems().add(stmt.toString());
                stack2.push(stmt);
            }

            while (!stack2.isEmpty()) {
                exeStack.push(stack2.pop());
            }

            IList<Integer> out = getSelectedPrgState().getOutput();
            IList<Integer> out2 = new Output<>();
            while (!out.isEmpty()) {
                int s = out.pop();
                output.getItems().add(String.valueOf(s));
                out2.add(s);
            }

            while (!out2.isEmpty()) {
                out.add(out2.pop());
            }

            ObservableList<HeapPair> hps = FXCollections.observableArrayList();
            for (int key : getSelectedPrgState().getHeap().getKeys()) {
                hps.add(new HeapPair(key, getSelectedPrgState().getHeap().get(key)));
            }
            heap.setItems(hps);

            ObservableList<TablePair> sts = FXCollections.observableArrayList();
            for (String key : getSelectedPrgState().getSymTable().getContent().keySet()) {
                sts.add(new TablePair(getSelectedPrgState().getSymTable().get(key), key));
            }

            symTable.setItems(sts);

            ObservableList<TablePair> fts = FXCollections.observableArrayList();
            for (int key : getSelectedPrgState().getFileTable().getContent().keySet()) {
                fts.add(new TablePair(key, getSelectedPrgState().getFileTable().get(key).getKey()));
            }
            filetable.setItems(fts);
        }
    }
}
