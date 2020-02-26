package source;

public class ExperimentList {

    public Experiment head = null;

    /**
     * @param e given node to add it's days' last.
     * @return insert experiment to the end of the day
     */
    Experiment addExp(Experiment e){

        if(head == null){
            head = e;
            return head;
        }

        Experiment save = head;
        while(save.day != e.day){
            if(save.next_day != null){
                save = save.next_day;
            }
            else{
                break;
            }
        }

        if(save.day != e.day){

            e.next_day = null;
            e.next_exp = null;
            save.next_day = e;
            if(save.next_exp == null){
                save.next_exp = e;
            }
            else{
                while(save.next_exp != null && save.day == save.next_exp.day){
                    save = save.next_exp;
                }
                save.next_exp = e;
            }
            return head;
        }

        else {

            while (true) {
                if (save.next_exp != null && save.day == save.next_exp.day) {
                    save = save.next_exp;
                } else {
                    break;
                }
            }
            e.next_exp = save.next_exp;
            e.next_day = null;
            save.next_exp = e;

            return head;
        }
    }


    /**
     * @param day get the experiment with the given day and position
     * @param index
     * @return
     */
    Experiment getExp(int day,int index){

        Experiment save = head;
        while(save.day != day ){
            save = save.next_day;
            if(save == null){
                return null;
            }
        }
        for(int i=1 ; i<=index ; ++i){
            if(save.next_exp != null && save.day == save.next_exp.day) {
                save = save.next_exp;
            }
            else{
                return null;
            }
        }
        return save;

    }


    /**
     * @param day set the experiment with the given day and position
     * @param index
     * @param e
     */
    void setExp(int day,int index,Experiment e ){

        Experiment save = head;
        while(save.day != day ){
            save = save.next_day;
            if(save == null){
                return;
            }
        }
        for(int i=1 ; i<=index ; ++i){
            if(save.next_exp != null && save.day == save.next_day.day) {
                save = save.next_exp;
            }
            else{
                return;
            }
        }

        save = e;

    }


    /**
     * @param day   remove the specified node with the given day and index.
     * @param index
     */
    void removeExp(int day,int index){

        Experiment save = head;

        while (save.next_day.day != day) {
            if(save.next_day != null){
                save = save.next_day;
            }
            else {
                return ;
            }
        }

        while(save.next_exp.day == save.day){
            save = save.next_exp;
        }


        if(index == 0) {
            Experiment temp = save;
            save = save.next_exp;

            int counter=0;
            while(save.next_exp != null ){
                if(save.day != save.next_exp.day){
                    ++counter;
                    break;
                }
                save = save.next_exp;
                ++counter;
            }
            if(counter == 0){
           /*     save = temp;
                save.next_day = save.next_day.next_day;
                while(save.next_exp != null && save.day == save.next_exp.day){
                    save = save.next_exp;
                }
                save.next_exp = save.next_day;
            */
                removeDay(day);
            }
            else{
                save = head;
                while (save.next_day.day != day) {
                    if(save.next_day != null){
                        save = save.next_day;
                    }
                    else {
                        return ;
                    }
                }
                save.next_day = temp.next_exp.next_exp;
                save.next_day.next_day = temp.next_exp.next_day;

                while(save.next_exp.day == save.day){
                    save = save.next_exp;
                }

                save.next_exp = temp.next_exp.next_exp;

            }

        }

        else {
            save = save.next_exp;

            for (int i = 2; i <= index; ++i) {
                if (save.next_exp != null && save.day == save.next_exp.day) {
                    save = save.next_exp;
                } else {
                    return;
                }
            }

            save.next_exp = save.next_exp.next_exp;

        }

    }


    /**
     * @param day list all completed experiments in a given day
     */
    void listExp(int day){

        Experiment save = head;

        while(save.day != day ){
            save = save.next_day;
            if(save == null){
                return;
            }
        }

        while(save != null && save.day == day){
            if(save.completed){
                System.out.println(save.toString());
            }
            save = save.next_exp;
        }

    }


    /**
     * @param day removes the day from list.
     */
    void removeDay(int day){
        Experiment save = head;

        while(save.next_day.day != day ){
            save = save.next_day;
            if(save.next_day == null){
                return;
            }
        }

        save.next_day = save.next_day.next_day;
        while(save.next_exp != null && save.day == save.next_exp.day){
            save = save.next_exp;
        }
        save.next_exp = save.next_day;


    }


    /**
     * @param day order the given day.
     */
    void orderDay(int day){
        Experiment save = head;

        while(save.day != day ){
            save = save.next_day;
            if(save == null){
                return;
            }
        }
        Experiment save2 = save;

        int counter = 0;
        Experiment temp = save;
        while(temp != null && temp.day == day){
            ++counter;
            temp = temp.next_exp;
        }

        for(int i = 0; i < counter ; ++i){
            for(int j = 0; j <counter ; ++j){
                if(save.day == save.next_exp.day) {
                    if (save.accuracy < save.next_exp.accuracy) {
                        String setup = save.setup;
                        int dday = save.day;
                        String time = save.time;
                        boolean completed = save.completed;
                        float accuracy = save.accuracy;

                        save.setup     = save.next_exp.setup    ;
                        save.day       = save.next_exp.day      ;
                        save.time      = save.next_exp.time     ;
                        save.completed = save.next_exp.completed;
                        save.accuracy  = save.next_exp.accuracy ;

                        save.next_exp.setup     = setup;
                        save.next_exp.day       = dday;
                        save.next_exp.time      = time;
                        save.next_exp.completed = completed;
                        save.next_exp.accuracy  = accuracy;
                    }
                }
                save = save.next_exp;
                if(save.next_exp == null){
                    break;
                }
            }
            save = save2;
        }


    }

    /**
     * @return By using bubble sort, according to accuracy sort the list in ascending order.
     */
    ExperimentList orderExperiments(){

        Experiment current = head;	// used to iterate over original list
        Experiment newList = null; // head of the new list

        Experiment newList_save = null;
        while (current != null)
        {
            if (newList == null) {
                newList = new Experiment(current.setup,current.time,current.completed,current.day,current.accuracy,current.next_exp,current.next_day);
                newList_save = newList;
            }
            else{
                newList.next_exp = new Experiment(current.setup,current.time,current.completed,current.day,current.accuracy,current.next_exp,current.next_day);
                newList = newList.next_exp;
            }
            current = current.next_exp;
        }
        newList = newList_save;



        Experiment save = newList;
        int counter = 0;

        Experiment temp = save;
        while(temp != null ){
            ++counter;
            temp = temp.next_exp;
        }

        for(int i = 0; i < counter ; ++i){
            while(save != null){
                if (save.accuracy < save.next_exp.accuracy) {
                    String setup = save.setup;
                    int day = save.day;
                    String time = save.time;
                    boolean completed = save.completed;
                    float accuracy = save.accuracy;

                    save.setup     = save.next_exp.setup    ;
                    save.day       = save.next_exp.day      ;
                    save.time      = save.next_exp.time     ;
                    save.completed = save.next_exp.completed;
                    save.accuracy  = save.next_exp.accuracy ;

                    save.next_exp.setup     = setup;
                    save.next_exp.day       = day;
                    save.next_exp.time      = time;
                    save.next_exp.completed = completed;
                    save.next_exp.accuracy  = accuracy;

                }
                save = save.next_exp;
                if(save.next_exp == null){
                    break;
                }
            }
            save = newList;
        }

        ExperimentList e = new ExperimentList();
        e.head = newList;

        return e;

    }


    /**
     * Your method
     */
    public void listAll() {
        System.out.println("List experiment view:");
        Experiment last = head;
        while( last != null) {
            System.out.println(last.toString());
            last = last.next_exp;
        }
        System.out.println("List day view:");
        last = head;
        while( last != null) {
            System.out.println(last.toString());
            last = last.next_day;
        }
    }

}