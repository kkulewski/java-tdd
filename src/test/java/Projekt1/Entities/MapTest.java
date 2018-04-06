package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MapTest
{
    @Test
    public void getField_GivenInvalidRowIndex_ThrowsIndexOutOfBoundsException()
    {
        // Arrange
        Map map = new Map(1);

        // Act & Assert
        assertThatThrownBy(() -> map.getField(1,0))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void getField_GivenInvalidColumnIndex_ThrowsIndexOutOfBoundsException()
    {
        // Arrange
        Map map = new Map(1);

        // Act & Assert
        assertThatThrownBy(() -> map.getField(0,1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void getField_GivenInvalidRowAndColumnIndex_ThrowsIndexOutOfBoundsException()
    {
        // Arrange
        Map map = new Map(1);

        // Act & Assert
        assertThatThrownBy(() -> map.getField(1,1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void getField_GivenValidIndex_WhenMapIsEmpty_ReturnsWaterField()
    {
        // Arrange
        Map map = new Map(2);

        // Act
        Field field = map.getField(1, 1);

        // Assert
        assertThat(field).isEqualTo(Field.Water);
    }
}
