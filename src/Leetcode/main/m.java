package Leetcode.main;

import Leetcode.beam.INode;

import java.util.concurrent.ConcurrentLinkedQueue;

public class m {
    public static void main(String[] args) {
      m m1=new m();
      m1.mcom01();
    }
    public void mcom01(){
        Integer[] i=new Integer[]{-1,1, null,-1, null,1};
        Integer[] i1=new Integer[]{-1,null,1};
        Integer[] i2=new Integer[]{-1,null,null};
        Integer[] i3=new Integer[]{null};
        //-1,1,-1,1,纯左子树
        INode aim=creatITree(i3);

    }
    public INode creatITree(Integer[] i){
        INode iNode=new INode();
        INode tNode;
        ConcurrentLinkedQueue<INode> queue=new ConcurrentLinkedQueue<>();
//        for (Integer temp:i) {
//            tNode=new INode();
//            if (temp==null){
//                tNode.val=null;
//                stackNode.add(tNode);
//                continue;
//            }
//            tNode.val=temp;
//            stackNode.add(tNode);
////            System.out.println(tNode.val);
////            Integer[] i=new Integer[]{-1,1, null,-1, null,1};
//        }
        tNode=iNode;
        boolean flag=true;
        boolean rflag=false;
        boolean lflag=false;
        INode temp;
        for (Integer itemp:i){
                if(itemp==null){
                    temp=null;

                }else {
                    temp=new INode();
                    temp.val=itemp;
                }

            if (iNode!=null)
            {
                if(iNode.val==null&&temp!=null){
                        iNode.val=temp.val;
                }else
                    if(iNode.left==null&&!lflag){
                    iNode.left=temp;
                    lflag=true;

                }else
                    if(iNode.right==null&&!rflag) {
                        iNode.right = temp;
                        rflag = true;
                    }
                if(lflag&&rflag){

//                    if(queue.isEmpty()){
//                        queue.add(iNode);
//                        /*当前节点如果该节点左节点为空，则从队列中拿右节点，右节点为空就没有再算的必要了*/
//                        iNode=iNode.left!=null?iNode.left: Objects.requireNonNull(queue.poll()).right;
//                    }
//                    else {
//                        iNode=queue.poll().right;
//                        /*从队列拿出的节点的右节点为空的情况下，从新再从拿一个节点*/
//                        while (iNode==null&&!queue.isEmpty()){
//                            iNode= queue.peek();
//                            if(iNode.left!=null){
//                                iNode=iNode.left;
//                                break;
//                            }
//                            else if(iNode.right!=null){
//                                iNode=iNode.right;
//                                queue.poll();
//                                break;
//                            }
//                        }
//                    }
                    /*把当前节点存入队列中，从队列中拿出一个节点，由该节点拿出左右子节点。
                    由flag决定先拿左子节点
                    */
                        queue.add(iNode);
                        iNode = null;
                        while (!queue.isEmpty()) {
                            iNode = queue.peek();
                            if (iNode.left != null && flag) {
                                iNode = iNode.left;
                                flag = false;
                                break;
                            } else if (iNode.right != null) {
                                iNode = iNode.right;
                                queue.poll();
                                flag = true;
                                break;
                            }
                            flag = true;
                            iNode=null;
                            queue.poll();
                        }
                        rflag=false;
                        lflag=false;
                    }



            } else
             {
                 throw new RuntimeException();
            }
        }
        iNode=tNode;
        return iNode;
    }
}
