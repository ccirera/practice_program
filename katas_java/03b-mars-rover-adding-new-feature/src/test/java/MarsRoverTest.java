import mars_rover.MarsRover;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MarsRoverTest {

    @Test
    public void does_nothing_when_receiving_empty_commands_sequence() {
        MarsRover marsRover = new MarsRoverBuilder().facing("N").build();

        marsRover.receive("");

        String direction = "N";
        assertThat(marsRover, is(new MarsRoverBuilder().startingAt(0, 0).facing(direction).build()));
    }

    @Test
    public void turns_right_when_pointing_north() {
        String direction = "N";
        MarsRover marsRover = new MarsRoverBuilder().startingAt(0, 0).facing(direction).build();

        marsRover.receive("r");

        assertThat(marsRover, is(new MarsRoverBuilder().startingAt(0, 0).facing("E").build()));
    }

    @Test
    public void turns_right_when_pointing_east() {
        MarsRover marsRover = new MarsRoverBuilder().startingAt(0, 0).facing("E").build();

        marsRover.receive("r");

        assertThat(marsRover, is(new MarsRoverBuilder().startingAt(0, 0).facing("S").build()));
    }

    @Test
    public void turns_right_when_pointing_south() {
        MarsRover marsRover = new MarsRoverBuilder().startingAt(0, 0).facing("S").build();

        marsRover.receive("r");

        assertThat(marsRover, is(new MarsRoverBuilder().startingAt(0, 0).facing("W").build()));
    }

    @Test
    public void turns_right_when_pointing_west() {
        MarsRover marsRover = new MarsRoverBuilder().startingAt(0, 0).facing("W").build();

        marsRover.receive("r");

        String direction = "N";
        assertThat(marsRover, is(new MarsRoverBuilder().startingAt(0, 0).facing(direction).build()));
    }

    @Test
    public void turns_left_when_pointing_north() {
        String direction = "N";
        MarsRover marsRover = new MarsRoverBuilder().startingAt(0, 0).facing(direction).build();

        marsRover.receive("l");

        assertThat(marsRover, is(new MarsRoverBuilder().startingAt(0, 0).facing("W").build()));
    }

    @Test
    public void turns_left_when_pointing_west() {
        MarsRover marsRover = new MarsRoverBuilder().startingAt(0, 0).facing("W").build();

        marsRover.receive("l");

        assertThat(marsRover, is(new MarsRoverBuilder().startingAt(0, 0).facing("S").build()));
    }

    @Test
    public void turns_left_when_pointing_south() {
        MarsRover marsRover = new MarsRoverBuilder().startingAt(0, 0).facing("S").build();

        marsRover.receive("l");

        assertThat(marsRover, is(new MarsRoverBuilder().startingAt(0, 0).facing("E").build()));
    }

    @Test
    public void turns_left_when_pointing_east() {
        MarsRover marsRover = new MarsRoverBuilder().startingAt(0, 0).facing("E").build();

        marsRover.receive("l");

        String direction = "N";
        assertThat(marsRover, is(new MarsRoverBuilder().startingAt(0, 0).facing(direction).build()));
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
}
