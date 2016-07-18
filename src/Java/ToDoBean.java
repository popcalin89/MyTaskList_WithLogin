/**
 * Created by caly on 7/17/2016.
 */
public class ToDoBean {


    ToDoBean(int id, String value) {
        this.id=id;
        this.whatToDo=value;
        isDone=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWhatToDo() {
        return whatToDo;
    }

    public void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public int id;
    public String whatToDo;
    public boolean isDone;

}
