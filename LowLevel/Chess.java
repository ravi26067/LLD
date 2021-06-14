class Chess{
	ChessBoard board;
	Player[] players;
	Player currentPlayer;
	List<Move> moves;
	GameStatus status;


	public boolean playMove(CellPosition start,CellPosition end,Piece piece);
	public boolean endGame();
	private void changeTurn();
}

class ChessBoard{
	List<List<Cell>> cells;

	public void resetBoard();
	public void updateBoard(Move move);

}

class Cell{
	Color color;
	Piece piece;
	CellPosition position;
}

class CellPosition{
	Char col;
	int row;
}

class Player{
	Account account;
	Color color;
	Time tileleft;

}


class Move{
	Player turn;
	Piece piece;
	Piece killedPiece;
	CellPosition start;
	CellPosition end;
}

class Account{
	private String username;
	private String password;
	private String email;
	private String name;
	private String phone;
}

enum GameStatus{
	BLACK_WIN,
	WHITE_WIN, 
	ACTIVE,
	PAUSED
}

enum Color{
	BLACK,
	WHITE
}

class Time{
	int mins;
	int secs;
}

abstract class Piece{
	Color color;
	public abstract boolean move(CellPosition from , CellPosition toPosition);
	public abstract List<CellPosition> possibleMoves(CellPosition start);
	public abstract boolean validateMove(CellPosition start,CellPosition end);

}

class Bishop extends Piece{
	Color color;
	public abstract boolean move(CellPosition from , CellPosition toPosition);
	public abstract List<CellPosition> possibleMoves(CellPosition start);
	public abstract boolean validateMove(CellPosition start,CellPosition end);

}

class Queen extends Piece{
	Color color;
	public abstract boolean move(CellPosition from , CellPosition toPosition);
	public abstract List<CellPosition> possibleMoves(CellPosition start);
	public abstract boolean validateMove(CellPosition start,CellPosition end);

}

class King extends Piece{
	Color color;
	public abstract boolean move(CellPosition from , CellPosition toPosition);
	public abstract List<CellPosition> possibleMoves(CellPosition start);
	public abstract boolean validateMove(CellPosition start,CellPosition end);

}

class Rook extends Piece{
	Color color;
	public abstract boolean move(CellPosition from , CellPosition toPosition);
	public abstract List<CellPosition> possibleMoves(CellPosition start);
	public abstract boolean validateMove(CellPosition start,CellPosition end);

}

class Knight extends Piece{
	Color color;
	public abstract boolean move(CellPosition from , CellPosition toPosition);
	public abstract List<CellPosition> possibleMoves(CellPosition start);
	public abstract boolean validateMove(CellPosition start,CellPosition end);

}

class Pawn extends Piece{
	Color color;
	public abstract boolean move(CellPosition from , CellPosition toPosition);
	public abstract List<CellPosition> possibleMoves(CellPosition start);
	public abstract boolean validateMove(CellPosition start,CellPosition end);

}



