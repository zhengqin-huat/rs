package cons;


import java.lang.reflect.ParameterizedType;

public abstract class BaseDao<T> {

        //模拟hibernate....
        private Session session;
        private Class clazz;


        //哪个子类调的这个方法，得到的class就是子类处理的类型
        public BaseDao(){
            Class clazz = this.getClass();  //拿到的是子类
            ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();  //BaseDao<Category>
            clazz = (Class) pt.getActualTypeArguments()[0];
            System.out.println(clazz);

        }


        public void add(T t){
            session.save(t);
        }

        public T find(String id){
            return (T) session.get(clazz, id);
        }

        public void update(T t){
            session.update(t);
        }

        public void delete(String id){
            T t = (T) session.get(clazz, id);
            session.delete(t);
        }


    }
    //    //继承抽象DAO，该实现类就有对应的增删改查的方法了
