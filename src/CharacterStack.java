import java.util.ArrayList;

public class CharacterStack {
    private ArrayList<Character> arrayList;
    private int top;
    public CharacterStack(){
        arrayList = new ArrayList<>();
        top=-1;
    }
    public void push(char ch){
        top++;
        arrayList.add(ch);
    }
    public char pop(){
        char ch = 0;
        if(!isEmpty()){
            ch = arrayList.get(top);
            arrayList.remove(top);
            top--;
        }
        return ch;
    }
    public boolean isEmpty() {
        return (top==-1);
    }
    public char topElement(){
        return arrayList.get(top);
    }
}
