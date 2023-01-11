
import java.util.ArrayList;
import java.util.List;

class Controller {

    Model model;
    Model view;
    Model tminate;
    Model io;
    Model io2;
    Model Ready;
    List<Model> readyBox = new ArrayList<Model>();
    List<Model> addio = new ArrayList<Model>();
    List<Model> addio2 = new ArrayList<Model>();
    List<Model> terminate = new ArrayList<Model>();
    List<Model> modelBox = new ArrayList<Model>();
    List<Model> cpu = new ArrayList<Model>();
    List<Model> ioq = new ArrayList<Model>();
    List<Model> ioq2 = new ArrayList<Model>();
    int clock = 0;
    double tt;
    double ww;
    int pID = 1;
    int IOI1 = 0;
    int IOI2 = 0;
    int memory = 0;
    float mm = 0;
    int sumpb = 0;

    Controller() {

    }

    void addProcess(int count) {
        //addprocess
        memory = (int) (Math.random() * (284) + 2);
        int pty = (int) (Math.random() * (10) + 5);
        model = new Model(pID, 0, 0, 0, 0, pty, count, memory);
        pID++;
        modelBox.add(model);
        readyBox.add(model);
    }

    public String showMain() { //tebel jobQueue

        String text = "";
        for (int index = 0; index < modelBox.size(); index++) {
            text += modelBox.get(index).getProcessID() + " ";
            text += modelBox.get(index).getState() + " ";
            text += modelBox.get(index).getCpuburst() + " ";
            text += modelBox.get(index).getWaitingtime() + " ";
            text += modelBox.get(index).getIotime() + " ";
            text += modelBox.get(index).getPriority() + " ";
            text += modelBox.get(index).getArrivaltime() + " ";
            text += modelBox.get(index).getMemory() + " ";
            text += ",";
        }
        return text;
    }

    public String showMonitor() { //mornitor
        try {
            String text = "";
            for (int index = 0; index < addio.size(); index++) {
                text = text + addio.get(index).getProcessID() + " ";
                text = text + addio.get(index).getState() + " ";
                text = text + addio.get(index).getIotime() + " ";
                text = text + ",";
            }
            return text;
        } catch (IndexOutOfBoundsException e) {

        }
        return null;
    }

    public String showIOQ() { //mornitor

        String text = "";
        for (int index = 0; index < ioq.size(); index++) {
            text = text + ioq.get(index).getProcessID() + " ";
            text = text + ioq.get(index).getState() + " ";
            text = text + ",";
        }
        return text;
    }
     public String showIOQ1() { //mornitor

        String text = "";
        for (int index = 0; index < ioq2.size(); index++) {
            text = text + ioq2.get(index).getProcessID() + " ";
            text = text + ioq2.get(index).getState() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showPrintter() { //printter

        String text = "";
        for (int index = 0; index < addio2.size(); index++) {
            text = text + addio2.get(index).getProcessID() + " ";
            text = text + addio2.get(index).getState() + " ";
            text = text + addio2.get(index).getIotime() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showCpu() {

        String text = "";
        for (int index = 0; index < readyBox.size(); index++) {
            text = text + readyBox.get(index).getProcessID() + " ";
            text = text + readyBox.get(index).getState() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showTerminate() {
        String text = "";
        for (int i = 0; i < terminate.size(); i++) {

            text = text + terminate.get(i).getProcessID() + " ";
            text = text + terminate.get(i).getState() + " ";
            text = text + terminate.get(i).getArrivaltime() + " ";
            text = text + terminate.get(i).getCpuburst() + " ";
            text = text + terminate.get(i).getWaitingtime() + " ";
            text = text + terminate.get(i).getTurnaround() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showready() {
        String text = "";
        for (int index = 0; index < readyBox.size(); index++) {
            text = text + readyBox.get(index).getProcessID() + " ";
            text = text + readyBox.get(index).getArrivaltime() + " ";
            text = text + readyBox.get(index).getPriority() + " ";
            text = text + ",";
        }
        return text;
    }

    public void Countwaitting(int count) {
        int w = 0, a;
        try {
            for (int i = 0; i < modelBox.size(); i++) {
                if (modelBox.get(i).getState() == "Ready") {
                    w = modelBox.get(i).getWaitingtime();
                    w += 1;
                    modelBox.get(i).setWaitingtime(w);
                } else {

                }
            }
        } catch (IndexOutOfBoundsException e) {

        }
    }

    void sortPriority() {
        int a, b;
        Model temp = new Model();
        for (a = 0; a < readyBox.size(); ++a) {
            for (b = 0; b < readyBox.size() - 1; ++b) {
                if (readyBox.get(b).getPriority() > readyBox.get(b + 1).getPriority()) {
                    temp = readyBox.get(b);
                    readyBox.set(b, readyBox.get(b + 1));
                    readyBox.set(b + 1, temp);
                }
            }
        }
    }

    void CpuBurstTime(int count) {
        try {
            int p;
            for (int i = 0; i < modelBox.size(); i++) {
                if (readyBox.get(0) == modelBox.get(i)) {
                    modelBox.get(i).setState(2);
                    p = modelBox.get(i).getCpuburst();
                    p += 1;
                    modelBox.get(i).setCpuburst(p);

                } else {
                    modelBox.get(i).setState(1);

                }

            }
        } catch (IndexOutOfBoundsException e) {

        }
    }

    void avgtt(int count) {
        tt = tt + count;
    }

    void avgww(int count) {
        ww = ww + count;
    }

    String AvgWaiting() {
        try {
            double w;
            w = ww / terminate.size();
            
            return String.format("%.2f", w);
        } catch (java.lang.ArithmeticException e) {

        }
        return null;
    }

    String AvgTurnaround() {
        try {
            double t;
            t = tt / terminate.size();
            
            return String.format("%.2f", t);
        } catch (java.lang.ArithmeticException e) {

        }
        return null;
    }

    void processTerminate(int count) {
        int t = 0;
        for (int i = 0; i < modelBox.size(); i++) {
            if (readyBox.get(0) == modelBox.get(i)) {
                modelBox.get(i).setState(4);
                t = count - modelBox.get(i).getArrivaltime();
                modelBox.get(i).setTurnaround(t);
                terminate.add(modelBox.get(i));
                avgtt(count - modelBox.get(i).getArrivaltime());
                avgww(modelBox.get(i).getWaitingtime());
                modelBox.remove(i);
                readyBox.remove(0);
                break;

            }
        }
    }

    void AddprocessIO(int count) {
//        try {
        for (int i = 0; i < modelBox.size(); i++) {
            if (readyBox.get(0) == modelBox.get(i)) {
                modelBox.get(i).setState(3);
                addio2.add(modelBox.get(i));
                ioq2.add(modelBox.get(i));
                readyBox.remove(0);
                break;
            }
        }
    }

    void CheckIOPrintter() {
        for (int i = 0; i < addio2.size(); i++) {
            if (addio2.get(i).getState() == "Ready") {
                addio2.get(i).setState(3);
            }
        }
    }

    void TimeIOPrintter(int count) {
        for (int i = 0; i < addio2.size(); i++) {
            if (addio2.get(i).getState() == "Waiting") {
                IOI1 = addio2.get(i).getIotime();
                IOI1 += 1;
                addio2.get(i).setIotime(IOI1);
            }
        }
    }

    public void EndIOPrintter() {

        for (int i = 0; i < modelBox.size(); i++) {
            
                addio2.get(i).getIotime();
                readyBox.add(addio2.get(i));
                addio2.remove(i);
                ioq2.remove(i);
                break;
            
        }
    }

    void AddprocessIOmonitor(int count) {

        for (int i = 0; i < modelBox.size(); i++) {
            if (modelBox.get(i).getState() == "Running") {
                modelBox.get(i).setState(3);
                addio.add(modelBox.get(i));
                ioq.add(modelBox.get(i));
                readyBox.remove(0);
                break;
            }

        }
    }

    void TimeIOmonitor(int count) {
        try {
            for (int i = 0; i < addio.size(); i++) {
                if (addio.get(i).getState() == "Waiting") {
                    IOI2 = addio.get(i).getIotime();
                    IOI2 += 1;
                    addio.get(i).setIotime(IOI2);

                }
            }
        } catch (IndexOutOfBoundsException e) {

        }
    }

    public void EndIOmonitor() {

        for (int i = 0; i < modelBox.size(); i++) {
            
                addio.get(i).getIotime();
                readyBox.add(addio.get(i));
                addio.remove(i);
                ioq.remove(i);
                 break;
            
           

        }
    }

    void CheckIOmonitor() {

        for (int i = 0; i < addio.size(); i++) {
            if (addio.get(i).getState() == "Ready") {
                addio.get(i).setState(3);
            }
        }
    }

    int Progressb() {

        int pb = 0;
        for (int i = 0; i < modelBox.size(); i++) {
            mm = modelBox.get(i).getMemory();
            pb += mm;
            sumpb = pb * 100 / 1024;
        }
        return sumpb;
    }

}
