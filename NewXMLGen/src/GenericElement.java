import java.awt.Color;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GenericElement extends GameElement
{
	public enum Type { SPEECH_BUBBLE, INFORMATION_BOX, TEXT_BOX, BUTTON }
	
	@XmlElement
	public Type type;
	@XmlElement
	public Color color;
	@XmlElement
	public String text;
}
