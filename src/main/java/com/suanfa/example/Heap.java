package com.suanfa.example;

/**
 * 大小根堆
 */
public class Heap {
    private static void show(int[] a){
        for(int v:a){
            System.out.print(v+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args){
        int[] values = {1,2,3,4,5,6,7,8,9,10};
        show(values);
        makeHeap(values);
        show(values);
        removeTopItem(values,values.length);
        show(values);
    }

    /**
     * 构建堆
     * @param values
     */
    private static void makeHeap(int[] values){
        //依次将元素加入堆
        for(int i=0;i<values.length;i++){
            //从一个新元素开始一直执行到根
            int index = i;
            while (index != 0){
                //父节点的下标
                int parent = (index-1)/2;
                //如果子节点的值小于等于父节点，任务完成终止while循环
                if(values[index] <= values[parent]){
                    break;
                }
                //交换子节点和父节点值
                int temp = values[index];
                values[index] = values[parent];
                values[parent] = temp;
                //索引指向父节点
                index = parent;
            }
        }
    }

    /**
     * 移除堆顶元素
     * @param values
     * @param count
     */
    private static void removeTopItem(int[] values,int count){
        //记录堆最顶端的元素用于之后返回
        int result = values[0];
        System.out.println("堆顶元素："+result);
        //将末尾元素移动到根
        values[0] = values[count-1];
        //维护堆的性质
        int index = 0;
        while (true){
            //子节点下标
            int child1 = 2*index + 1;
            int child2 = 2*index + 2;
            //如果子节点的下标超出树的末端
            //记录父节点的下标
            if(child1>=count)
                child1 = index;
            if(child2>=count)
                child2 = index;

            //如果满足堆的性质，维护完成，推出while循环
            if(values[index]>=values[child1] && values[index]>=values[child2]){
                break;
            }
            int swap_child = child1;
            //获得更大子节点下标
            if(values[child1] > values[child2]){
                swap_child = child1;
            }else {
                swap_child = child2;
            }
            //父节点与更大子节点交换
            int temp = values[index];
            values[index] = values[swap_child];
            values[swap_child] = temp;

            index = swap_child;
        }
    }
}
