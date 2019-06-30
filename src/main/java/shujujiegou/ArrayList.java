package shujujiegou;

/**
 * 顺序表，底层采用数组，长度可以动态扩展
 */
public class ArrayList implements List {
    private Object[] elementData;//底层是一个数组，目前还没有确定长度
    private int size; //不是数组分配的空间，二十元素的个数
    private final Object[] EMPTY_ELEMENTDATA = {};

    //initialCapacity  数组的初始长度
    public ArrayList(int initialCapacity) {
        //给数组指定分配空间
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public ArrayList() {
      this.elementData=EMPTY_ELEMENTDATA;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if(i<0||i>=size){
            throw new MyIndexOutOfBoundsException("数组下标越界异常");
        }
        return elementData[i];
    }

    @Override
    public boolean isEmpty() {
        return 0==size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public void add(Object o) {
        //给数组赋值
        elementData[size]=o;
        //元素个数加一
        size++;
    }
}
