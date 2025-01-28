package chat;

public class Mensaje {

	private String mensaje;

	public Mensaje() {
		switch ((int) (Math.random() * 7)) {
		case 0:
			mensaje = "Hola";
			break;
		case 1:
			mensaje = "Buenos dias";
			break;
		case 2:
			mensaje = "¿Como estas?";
			break;
		case 3:
			mensaje = "¿Que tal estuvo el dia?";
			break;
		case 4:
			mensaje = "Me alegra verte por aqui";
			break;
		case 5:
			mensaje = "Buenas noches";
			break;
		case 6:
			mensaje = "Espero que tengas un dia excelente";
			break;
		default:
			mensaje = "Buenas tardes";
		}
	}

	public String getMensaje() {
		return mensaje;
	}

}
