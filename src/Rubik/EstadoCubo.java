package Rubik;

import java.util.Set;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class EstadoCubo {

	private String[][][] cubo;
	private final int Sides = 6;
	private final int rows = 3;
	private final int cols = 3;

	public static Action U = new DynamicAction("U");
	public static Action F = new DynamicAction("F");
	public static Action D = new DynamicAction("D");

	public static Action L = new DynamicAction("L");
	public static Action R = new DynamicAction("R");
	public static Action B = new DynamicAction("B");

	public static Action U_ = new DynamicAction("U_");
	public static Action F_ = new DynamicAction("F_");
	public static Action D_ = new DynamicAction("D_");

	public static Action L_ = new DynamicAction("L_");
	public static Action R_ = new DynamicAction("R_");
	public static Action B_ = new DynamicAction("B_");

	public EstadoCubo() {

		this.cubo = new String[Sides][rows][cols];

		for (int i = 0; i < Sides; i++) {
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {

					switch (i) {
					case 0:
						cubo[i][r][c] = "green";
						break;
					case 1:
						cubo[i][r][c] = "orange";
						break;
					case 2:
						cubo[i][r][c] = "blue";
						break;
					case 3:
						cubo[i][r][c] = "red";
						break; 
					case 4:
						cubo[i][r][c] = "yellow";
						break;
					case 5:
						cubo[i][r][c] = "white";
						break;
					}
				}
			}
		}
	}

	public EstadoCubo(Set<Action> actions) {
		this();
		for (Action a : actions) {
			switch (((DynamicAction) a).getName()) {
			case "U":
				this.moveU();
				break;
			case "F":
				this.moveF();
				break;
			case "D":
				this.moveD();
				break;
			case "L":
				this.moveL();
				break;
			case "R":
				this.moveR();
				break;
			case "B":
				this.moveB();
				break;
			case "U_":
				this.moveU_();
				break;
			case "F_":
				this.moveF_();
				break;
			case "D_":
				this.moveD_();
				break;
			case "L_":
				this.moveL_();
				break;
			case "R_":
				this.moveR_();
				break;
			case "B_":
				this.moveB_();
				break;
			}
		}
	}

	public EstadoCubo(EstadoCubo estado) {
		this.cubo = estado.cubo;
	}

	public void turnFaceCW(int faceIdx) {
		String pos00 = cubo[faceIdx][0][0];
		String pos01 = cubo[faceIdx][0][1];
		String pos02 = cubo[faceIdx][0][2];
		String pos10 = cubo[faceIdx][1][0];
		String pos12 = cubo[faceIdx][1][2];
		String pos20 = cubo[faceIdx][2][0];
		String pos21 = cubo[faceIdx][2][1];
		String pos22 = cubo[faceIdx][2][2];
		cubo[faceIdx][0][0] = pos20;
		cubo[faceIdx][0][1] = pos10;
		cubo[faceIdx][0][2] = pos00;
		cubo[faceIdx][1][0] = pos21;
		cubo[faceIdx][1][2] = pos01;
		cubo[faceIdx][2][0] = pos22;
		cubo[faceIdx][2][1] = pos12;
		cubo[faceIdx][2][2] = pos02;
	}

	public void turnFaceACW(int faceIdx) {
		String pos00 = cubo[faceIdx][0][0];
		String pos01 = cubo[faceIdx][0][1];
		String pos02 = cubo[faceIdx][0][2];
		String pos10 = cubo[faceIdx][1][0];
		String pos12 = cubo[faceIdx][1][2];
		String pos20 = cubo[faceIdx][2][0];
		String pos21 = cubo[faceIdx][2][1];
		String pos22 = cubo[faceIdx][2][2];
		cubo[faceIdx][0][0] = pos02;
		cubo[faceIdx][0][1] = pos12;
		cubo[faceIdx][0][2] = pos22;
		cubo[faceIdx][1][0] = pos01;
		cubo[faceIdx][1][2] = pos21;
		cubo[faceIdx][2][0] = pos00;
		cubo[faceIdx][2][1] = pos10;
		cubo[faceIdx][2][2] = pos20;
	}

	public void collateralMovementsCW(int face1, int face2, int face3, int face4) {
		String aux400 = cubo[face4][0][0];
		String aux401 = cubo[face4][0][1];
		String aux402 = cubo[face4][0][2];

		cubo[face4][0][0] = cubo[face1][0][0];
		cubo[face4][0][1] = cubo[face1][0][1];
		cubo[face4][0][2] = cubo[face1][0][2];

		cubo[face1][0][0] = cubo[face2][0][0];
		cubo[face1][0][1] = cubo[face2][0][1];
		cubo[face1][0][2] = cubo[face2][0][2];

		cubo[face2][0][0] = cubo[face3][0][0];
		cubo[face2][0][1] = cubo[face3][0][1];
		cubo[face2][0][2] = cubo[face3][0][2];

		cubo[face3][0][0] = aux400;
		cubo[face3][0][1] = aux401;
		cubo[face3][0][2] = aux402;
	}

	public void collateralMovementsACW(int face1, int face2, int face3, int face4) {
		String aux100 = cubo[face1][0][0];
		String aux101 = cubo[face1][0][1];
		String aux102 = cubo[face1][0][2];

		cubo[face1][0][0] = cubo[face4][0][0];
		cubo[face1][0][1] = cubo[face4][0][1];
		cubo[face1][0][2] = cubo[face4][0][2];

		cubo[face4][0][0] = cubo[face3][0][0];
		cubo[face4][0][1] = cubo[face3][0][1];
		cubo[face4][0][2] = cubo[face3][0][2];

		cubo[face3][0][0] = cubo[face2][0][0];
		cubo[face3][0][1] = cubo[face2][0][1];
		cubo[face3][0][2] = cubo[face2][0][2];

		cubo[face2][0][0] = aux100;
		cubo[face2][0][1] = aux101;
		cubo[face2][0][2] = aux102;
	}

	public void moveU() {
		turnFaceCW(4);
		collateralMovementsCW(0, 1, 2, 3);
	}

	public void moveF() {
		turnFaceCW(1);
		collateralMovementsCW(5, 2, 4, 0);

	}

	public void moveD() {
		turnFaceCW(5);
		collateralMovementsCW(0, 3, 2, 1);
	}

	public void moveL() {
		turnFaceCW(0);
		collateralMovementsCW(5, 1, 4, 3);
	}

	public void moveR() {
		turnFaceCW(2);
		collateralMovementsCW(5, 3, 4, 1);
	}

	public void moveB() {
		turnFaceCW(3);
		collateralMovementsCW(4, 2, 5, 0);
	}

	public void moveU_() {
		turnFaceACW(4);
		collateralMovementsACW(0, 1, 2, 3);
	}

	public void moveF_() {
		turnFaceACW(1);
		collateralMovementsACW(5, 2, 4, 0);

	}

	public void moveD_() {
		turnFaceACW(5);
		collateralMovementsACW(0, 3, 2, 1);
	}

	public void moveL_() {
		turnFaceACW(0);
		collateralMovementsACW(5, 1, 4, 3);
	}

	public void moveR_() {
		turnFaceACW(2);
		collateralMovementsACW(5, 3, 4, 1);
	}

	public void moveB_() {
		turnFaceACW(3);
		collateralMovementsACW(4, 2, 5, 0);
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		EstadoCubo otroEstado = (EstadoCubo) o;

		for (int i = 0; i < Sides; i++) {
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (this.cubo[i][r][c] != otroEstado.cubo[i][r][c])
						return false;
				}
			}
		}
		return true;
	}
	
	public int hashCode() {
		int value1, value2;
		boolean value3;
		
		if(this.cubo[5][2][1] == this.cubo[5][0][1] && this.cubo[5][2][1] == this.cubo[5][1][1] && this.cubo[5][2][0] == this.cubo[5][2][1]) value3 = true;
		else value3 = false;
		
		value1 = (this.cubo[4][0][0] == this.cubo[4][0][1]) ? (this.cubo[4][0][0] == this.cubo[4][1][1]) ? (this.cubo[4][2][0] == this.cubo[4][2][1]) ? 1 : 2  : 3 : 4;
		
		value2 = (this.cubo[3][0][0] == this.cubo[3][0][1]) ? (this.cubo[3][2][0] == this.cubo[3][1][1]) ? 15 : 5 : 0;
		
		return (100 * value1) + (10* value2) + ( value3? 1 : 0);
		
		}
	
	
	
}
