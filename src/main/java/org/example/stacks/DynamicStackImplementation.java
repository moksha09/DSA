package org.example.stacks;

public class DynamicStackImplementation extends StackImplementation{

    public DynamicStackImplementation(){
        super(); // it will StackImplementation()
    }

    public  DynamicStackImplementation(int size){
        super(size);
    }

    @Override
    public boolean push(int item){

        // in case the array is full - double the size -
        if(this.isFull()){
            // double the array size -
            int[] temp = new int[data.length * 2];

            // copy all previous item in new data -
            for(int i=0; i< data.length; i++){
                temp[i] = data[i];
            }
            data = temp;
        }

        return super.push(item);
    }

}
