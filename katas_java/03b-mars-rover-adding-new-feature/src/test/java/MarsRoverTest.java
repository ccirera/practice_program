import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MarsRoverTest {

    @Test
    public void does_nothing_when_receiving_empty_commands_sequence() {
        MarsRover marsRover = getMarsRoverNorth();

        marsRover.receive("");

        assertThat(marsRover, is(getMarsRoverNorth()));
    }

    @Test
    public void turns_right_when_pointing_north() {
        MarsRover marsRover = getMarsRoverNorth();

        marsRover.receive("r");

        assertThat(marsRover, is(getMarsRoverEast()));
    }

    @Test
    public void turns_right_when_pointing_east() {
        MarsRover marsRover = getMarsRoverEast();

        marsRover.receive("r");

        assertThat(marsRover, is(getMarsRoverSouth()));
    }

    @Test
    public void turns_right_when_pointing_south() {
        MarsRover marsRover = getMarsRoverSouth();

        marsRover.receive("r");

        assertThat(marsRover, is(getMarsRoverWest()));
    }

    @Test
    public void turns_right_when_pointing_west() {
        MarsRover marsRover = getMarsRoverWest();

        marsRover.receive("r");

        assertThat(marsRover, is(getMarsRoverNorth()));
    }

    @Test
    public void turns_left_when_pointing_north() {
        MarsRover marsRover = getMarsRoverNorth();

        marsRover.receive("l");

        assertThat(marsRover, is(getMarsRoverWest()));
    }

    @Test
    public void turns_left_when_pointing_west() {
        MarsRover marsRover = getMarsRoverWest();

        marsRover.receive("l");

        assertThat(marsRover, is(getMarsRoverSouth()));
    }

    @Test
    public void turns_left_when_pointing_south() {
        MarsRover marsRover = getMarsRoverSouth();

        marsRover.receive("l");

        assertThat(marsRover, is(getMarsRoverEast()));
    }

    @Test
    public void turns_left_when_pointing_east() {
        MarsRover marsRover = getMarsRoverEast();

        marsRover.receive("l");

        assertThat(marsRover, is(getMarsRoverNorth()));
    }

    @Test
    public void moves_forward_when_pointing_north() {
        MarsRover marsRover = new MarsRover(5,4, "N");

        marsRover.receive("f");

        assertThat(marsRover, is(new MarsRover(5,5, "N")));
    }

    @Test
    public void moves_forward_when_pointing_east() {
        MarsRover marsRover = new MarsRover(5,4, "E");

        marsRover.receive("f");

        assertThat(marsRover, is(new MarsRover(6,4, "E")));
    }

    @Test
    public void moves_forward_when_pointing_south() {
        MarsRover marsRover = new MarsRover(5,4, "S");

        marsRover.receive("f");

        assertThat(marsRover, is(new MarsRover(5,3, "S")));
    }

    @Test
    public void moves_forward_when_pointing_west() {
        MarsRover marsRover = new MarsRover(5,4, "W");

        marsRover.receive("f");

        assertThat(marsRover, is(new MarsRover(4,4, "W")));
    }

    @Test
    public void moves_backward_when_pointing_north() {
        MarsRover marsRover = new MarsRover(5,4, "N");

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(5,3, "N")));
    }

    @Test
    public void moves_backward_when_pointing_east() {
        MarsRover marsRover = new MarsRover(5,4, "E");

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(4,4, "E")));
    }

    @Test
    public void moves_backward_when_pointing_south() {
        MarsRover marsRover = new MarsRover(5,4, "S");

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(5,5, "S")));
    }

    @Test
    public void moves_backward_when_pointing_west() {
        MarsRover marsRover = new MarsRover(5,4, "W");

        marsRover.receive("b");

        assertThat(marsRover, is(new MarsRover(6,4, "W")));
    }

    @Test
    public void receives_multiple_commands() {
        MarsRover marsRover = new MarsRover(7, 4, "E");

        marsRover.receive("fr");

        assertThat(marsRover, is(new MarsRover(8, 4, "S")));
    }

    @Test
    public void ignores_unknown_commands() {
        MarsRover marsRover = new MarsRover(7, 4, "E");

        marsRover.receive("*");

        assertThat(marsRover, is(new MarsRover(7, 4, "E")));
    }

    private MarsRover getMarsRoverNorth() {
        String direction = "N";
        return getMarsRoverInOrigin(direction);
    }

    private MarsRover getMarsRoverEast() {
        String direction = "E";
        return getMarsRoverInOrigin(direction);
    }

    private MarsRover getMarsRoverSouth() {
        String direction = "S";
        return getMarsRoverInOrigin(direction);
    }

    private MarsRover getMarsRoverWest() {
        String direction = "W";
        return getMarsRoverInOrigin(direction);
    }

    private MarsRover getMarsRoverInOrigin(String direction) {
        return new MarsRoverBuilder().setCoordinates(0, 0).setDirection(direction).build();
    }
}
