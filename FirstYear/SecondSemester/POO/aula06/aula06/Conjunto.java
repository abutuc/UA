package aula06;
public class Conjunto {
    private int[] content;
    private int[] copy;
    private int count;
    public Conjunto(){
        content = new int[1];
        count = 0;
    }

    public int getValue(int i){
        return content[i];
    }

    public void insert(int n){

        if (count == 0){
            content[0] = n;
            count++;
        }

        else if (!contains(n)){
            copy = content.clone();
            count++;
            content = new int[count];

            for (int f = 0; f < copy.length; f++){
                content[f] = copy[f];
            }
            content[copy.length] = n;
        }
    }

    public boolean contains(int n){
        for (int i = 0; i<content.length; i++){
            if (content[i] == n){
                return true;
            }
        }
        return false;
    }

    public void remove(int n){
        if(contains(n)){
            copy = content.clone();
            count--;
            boolean removed = false;
            content = new int[count];
            int temp = 0;
            for (int f = 0; f < copy.length; f++){
                if (!removed) {
                    temp = f;
                }
                else if (removed){

                    temp = f-1;
                }
                if (copy[f] == n){
                    removed = true;
                    continue;
                }
                content[temp] = copy[f];
            }

        }
    }

    public void empty(){
        content = new int[1];
        count = 0;
    }

    public int size(){
        int temp_count = 0;
        for (int i = 0; i < content.length; i++){
            temp_count++;
        }
        return temp_count;
    }

    public Conjunto unir(Conjunto add){
        Conjunto uniao = new Conjunto();
        for (int i = 0; i < size(); i++){
            uniao.insert(this.content[i]);
        }
        for (int f = 0; f < add.size(); f++){
            if(uniao.contains(f)){
                continue;
            }
            else{
                uniao.insert(add.getValue(f));
            }
        }
        return uniao;
    }

    public Conjunto interset(Conjunto inter){
        Conjunto interset = new Conjunto();
        for(int f = 0; f < this.size(); f++){
            for (int i = 0; i < inter.size(); i++){
                if((this.content[f] == inter.getValue(i))){
                    interset.insert(this.content[f]);
                }
            }
            }
        
        return interset;
    }

    public Conjunto subtrair(Conjunto diff){
        Conjunto diferenca = new Conjunto();
        
        for (int i = 0; i < this.content.length; i++){
            diferenca.insert(this.content[i]);
        }

        for (int f = 0; f < diff.size(); f++){
            diferenca.remove(diff.getValue(f));
        }
        return diferenca;
    }

    public String toString(){
        String s = "";
        if (count != 0){
            for (int c = 0; c < content.length; c++){
                s += Integer.toString(content[c]) + " ";
            }
            return s;
        }
        else{
            return s;
        }

    }
}
