package Pitcher;

public class Pitcher {
    private int capacity;
    private int content;

    public Pitcher(int capacity){
        this.capacity = capacity;
        this.content = 0;
    }

    public void fullRefill(){
        this.content = this.capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getContent() {
        return content;
    }

    public void partialRefill(int howMuchToRefill){
        if(this.content + howMuchToRefill > this.capacity){
            this.content = this.capacity;
        } else {
            this.content += howMuchToRefill;
        }
    }

    public void setContent(int content) {
        this.content = content;
    }

    public void refillFrom(Pitcher pitcher){
        if (this.content + pitcher.content > this.capacity){
            this.content = this.capacity;
            pitcher.setContent(pitcher.content - this.capacity);
        } else {
            this.content += pitcher.content;
            pitcher.setContent(pitcher.content - this.content);
        }
    }

    public void empty(){
        this.capacity = 0;
    }

    /*
        |       | |
        |  |    | _
     */
}
