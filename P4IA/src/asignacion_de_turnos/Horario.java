package asignacion_de_turnos;

import java.util.ArrayList;
import java.util.List;

import aima.core.util.datastructure.XYLocation;

public class Horario {

	private Profesor[][] horario;
	private int[][] turnos;
	
	private int size;
	private int turnosYaAsignados;
	private int goal;
	
	public Horario(int size) {
		this.size = size;
		this.setTurnosYaAsignados(0);
		horario = new Profesor[size][size];
		turnos = new int[size][size];
		
		int t = 1;
		
		for(int i = 0; i < size; i++){ //Lunes  Martes Miercoles Jueves
			for (int j = 0; j < size; j++){
				horario[i][j] = new Profesor("");
				turnos[i][j] = t;
				t +=4;
			}
			t -= 11;
		}
	}
	
	
	public void addProfesorAt(XYLocation loc, Profesor p){
	
		if (!ProfesorExistsAt(loc)){
			int i = loc.getXCoOrdinate();
			int j = loc.getYCoOrdinate();
			if(!p.getRestricciones().contains(turnos[i][j])){
				p.addLocatedAt(loc);
				horario[i][j] = p;
				this.setTurnosYaAsignados(this.getTurnosYaAsignados() + 1);
			}
		}
	}

	public void removeProfesorAt(XYLocation loc){
		if (ProfesorExistsAt(loc)){
			int i = loc.getXCoOrdinate();
			int j = loc.getYCoOrdinate();
			horario[i][j].removeLocatedAt(loc);
			horario[i][j].nombre = "";
			horario[i][j].setRestricciones(null);
			horario[i][j].setPreferencias(null);
		}
	}
	
	public boolean ProfesorExistsAt(XYLocation l) {
		return (ProfesorExistsAt(l.getXCoOrdinate(), l.getYCoOrdinate()));
	}
	private boolean ProfesorExistsAt(int x, int y) {
		return (horario[x][y].nombre != "");
	}

	public int getSize() {
		return size;
	}

	public List<XYLocation> getProfesorPositions() {
		ArrayList<XYLocation> result = new ArrayList<XYLocation>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (ProfesorExistsAt(i, j))
					result.add(new XYLocation(i, j));
			}
		}
		return result;
	}

	public int getTurnosYaAsignados() {
		return turnosYaAsignados;
	}
		
	public Profesor getProfesorAt(XYLocation loc){
		int x = loc.getXCoOrdinate();
		int y = loc.getYCoOrdinate();
		return horario[x][y];
	}
	
	public int getTurnoAt(XYLocation loc){
		int x = loc.getXCoOrdinate();
		int y = loc.getYCoOrdinate();
		return turnos[x][y];
	}

	public int getGoal() {
		return goal;
	}

	public void setTurnosYaAsignados(int turnosYaAsignados) {
		this.turnosYaAsignados = turnosYaAsignados;
	}

	
	public void setGoal(int g){
		this.goal = g;
	}
}
