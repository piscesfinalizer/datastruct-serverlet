public class Visitor {
    public String id;//客户端传入的标识ID，我用的是用户唯一标识
    public int order;//表明在队伍中的次序

    public Visitor(String _id, int _order){
        this.id = _id;
        this.order = _order;
    }
}
