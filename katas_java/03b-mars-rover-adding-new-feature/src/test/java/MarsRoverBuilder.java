import mars_rover.MarsRover;

public class MarsRoverBuilder {

    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private String direction = "N";

    public MarsRoverBuilder startingAt(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        return this;
    }

    public MarsRoverBuilder facing(String direction) {
        this.direction = direction;
        return this;
    }

    public MarsRover build() {
        return new MarsRover(xCoordinate, yCoordinate, direction);
    }
}
