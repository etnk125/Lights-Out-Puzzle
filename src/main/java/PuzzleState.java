public class PuzzleState{
    public String state;
    public int button;
    public int code;
    
    public PuzzleState(String s){
        state = s;
        try{
            code = Integer.parseInt(s,2);
        }
        catch(NumberFormatException e){
            code = -1;
        }
    }
    
    public String getState(){
        return state;
    }
    
    public int getButton(){
        return button;
    }
    
    public void setButton(int n){
        button=n+1;
    }
    
    public boolean equals(Object o) {
        PuzzleState other = (PuzzleState) o;
        return Integer.toString(code).equalsIgnoreCase(Integer.toString(other.hashCode()));
    }
    
    public int hashCode() {
        return code;
    }
}


