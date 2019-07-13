package hw6.enums;

public enum TestData {

    NUMBER_USER_TABLE_RECORDS(6);

    private int count;

    TestData(int count){
        this.count = count;
    }
    public int getCount(){
        return count;
    }
}
