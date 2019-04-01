import mars_rover.MarsRover;

public class MarsRoverBuilder {

    private int xCoordinate;
    private int yCoordinate;
    private String direction;

    public MarsRoverBuilder setCoordinates(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        return this;
    }

    public MarsRoverBuilder setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public MarsRover build() {
        return new MarsRover(xCoordinate, yCoordinate, direction);
    }
}
