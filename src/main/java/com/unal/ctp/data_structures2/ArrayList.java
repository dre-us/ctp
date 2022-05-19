package com.unal.ctp.d_structures;

public class ArrayList<T> {

    private int N = 20;
    private int count;
    private int position;
    private T[] listArray;
    T reference;

    public ArrayList(){
        count = 0;
        position = 0;
        listArray = (T[]) new Object[N];
    }

    public boolean empty(){
        return count == 0;
    }

    public boolean full(){
        return count == N;
    }

    public boolean insert(T item){
        if (find(item) != -1)
            return false;
		insertBack(item);
		return true;
    }

    public boolean insertBack(T item){
        boolean inserted = false;
        if(!full()){
            listArray[count++] = item;
            inserted = true;
        }
        else{
            changeCapacity();

            listArray[count++] = item;
            inserted = true;
        }
        return inserted;
    }

    public void deleteBack() {
        --count;
    }

    public int size(){
        return count;
    }

    public void changeCapacity(){
        N = N*5;
        T[] temporalArray = (T[]) new Object[N];
        for (int i = 0; i < size(); ++i)
            temporalArray[i] = this.listArray[i];
	    this.listArray = temporalArray;
    }

    public void set(int index, T item){
        if(index<0 || index >= size())
            throw new RuntimeException("Indice fuera del rango");
        this.listArray[index] = item;
    }

    public T get(int index){
        if(index<0 || index >= size())
            throw new RuntimeException("Indice fuera del rango");
        return this.listArray[index];
    }

    public boolean remove(T item){
        boolean deleted = false;
        int p = find(item);
        if(!empty()){
            if(p != -1){
                for(int j = p; j < count-1; j++)
                    listArray[j] = listArray[j+1];
                count--;
                deleted = true;
            }
        }
        else
            throw new RuntimeException("La lista está vacía");
        return deleted;
    }

    public void delete(int index){
        if(!empty()){
            if(index<0 || index >= size())
                throw new RuntimeException("Indice fuera del rango");
            for(int j = index; j+1 < size(); j++)
                listArray[j] = listArray[j+1];
            count--;
        }
        else
            throw new RuntimeException("La lista está vacía");
    }

    public int find(T item){
        for(int i = 0; i < count; i++){
            if(item.equals(listArray[i])){
                return i;
            }
        }
        return -1;
    }

    public void output(){
        for(int i = 0; i<count; i++){
            System.out.print(listArray[i] + " ");
        }
    }
}
