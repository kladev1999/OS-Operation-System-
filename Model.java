
public class Model {

    String state[] = {"New", "Ready", "Running", "Waiting", "Terminate"};
    private int processID;
    private int arrivaltime;
    private int cpuburst;
    private int waitingtime;
    private int iotime;
    private int priority;
    private int memory;
    private int Turnaround;
    private int index;

    public Model(int proseccID, int index, int cpuburst, int waitingtime, int iotime, int priority, int arrivaltime, int memory) {
        //jobQeue
        this.processID = proseccID;
        this.index = index;
        this.cpuburst = cpuburst;
        this.arrivaltime = arrivaltime;
        this.waitingtime = waitingtime;
        this.iotime = iotime;
        this.priority = priority;
        this.memory = memory;

    }

    Model(int proseccID, int index, int arrivaltime, int waitingtime, int iotime) { //terminate
        this.processID = proseccID;
        this.cpuburst = index;
        this.arrivaltime = arrivaltime;
        this.waitingtime = waitingtime;
        this.iotime = iotime;

    }

    Model(int proseccID, int index, int iotime) { //IO
        this.processID = proseccID;
        this.index = index;
        this.iotime = iotime;
    }

    Model(int proseccID, int index) { //CPU
        this.processID = proseccID;
        this.index = index;

    }

    Model(int proseccID) { //Q
        this.processID = proseccID;

    }

    Model(int proseccID, int arrivaltime, int priority, int memory) { //readyQeue

        this.processID = proseccID;
        this.arrivaltime = arrivaltime;
        this.priority = priority;
    }

    public Model() {

    }


    public void setState(int index) {
        this.index = index;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public void setArrivaltime(int arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public void setWaitingtime(int waitingtime) {
        this.waitingtime = waitingtime;
    }

    public void setIotime(int iotime) {
        this.iotime = iotime;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getState() {
        return state[index];
    }

    public int getProcessID() {
        return processID;
    }

    public int getArrivaltime() {
        return arrivaltime;
    }

    public int getWaitingtime() {
        return waitingtime;
    }

    public int getIotime() {
        return iotime;
    }

    public int getPriority() {
        return priority;
    }

    public int getMemory() {
        return memory;
    }

    public int getTurnaround() {
        return Turnaround;
    }

    public void setTurnaround(int Turnaround) {
        this.Turnaround = Turnaround;
    }

    public int getCpuburst() {
        return cpuburst;
    }

    public void setCpuburst(int cpuburst) {
        this.cpuburst = cpuburst;
    }

}
