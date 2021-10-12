package testDome;

enum Side { NONE, LEFT, RIGHT }

public class ChainLink {
    private ChainLink left, right;
    final int position = 0;
    
    public void append(ChainLink rightPart) {
        if (this.right != null)
            throw new IllegalStateException("Link is already connected.");
       // this.position = position;
        this.right = rightPart;
        rightPart.left = this;
       // position++;
    }
    
    public Side longerSide() {        
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        if (this.position > position / 2) 
        {
        	return Side.LEFT;
        }
        
        if (this.position < position / 2) 
        {
        	return Side.LEFT;
        }
        
        else
        {
        	return Side.NONE;
        }
        
    }
    
    public static void main(String[] args) {
        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        left.append(middle);
        middle.append(right);
        System.out.println(left.longerSide());
    }
}
