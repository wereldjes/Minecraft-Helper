package minecrafthelper.Domain;

/**
 *
 * @author Dominique
 */
public class Block {
    private int type;
    private int meta;
    private String name;
    private String text_type;

    public Block(int type, int meta, String name, String text_type) {
        this.type = type;
        this.meta = meta;
        this.name = name;
        this.text_type = text_type;
    }
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText_type() {
        return text_type;
    }

    public void setText_type(String text_type) {
        this.text_type = text_type;
    }
    
    
}
