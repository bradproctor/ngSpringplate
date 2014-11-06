package net.bradproctor.ngspringplate.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;


@MappedSuperclass
public abstract class BaseDomain implements Serializable
{
    private static final long serialVersionUID = 587561713846566189L;

    public String toString()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");

        //use reflection to obtain values
        for (Method method : this.getClass().getDeclaredMethods()) {
            if (!(method.getName().startsWith("get"))  ) {
                continue;
            }

            Object obj=null;
            try {
                obj = method.invoke(this, (Object[])null);
            } catch (Exception e){
                //leave as null
            }

            if((obj instanceof Collection)||(obj instanceof BaseDomain)){
                continue;
            }

            buffer.append(method.getName().substring(3)).append("='").append(obj).append("' ");

        }
        buffer.append("]");

        return buffer.toString();
    }
}