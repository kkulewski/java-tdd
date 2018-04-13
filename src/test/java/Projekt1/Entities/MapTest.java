package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MapTest
{
    @Test
    void getField_GivenInvalidRowIndex_ThrowsIndexOutOfBoundsException()
    {
        // Arrange
        Map map = new Map(1);
        Coordinate coord = new Coordinate(1,0);

        // Act & Assert
        assertThatThrownBy(() -> map.getField(coord))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void getField_GivenInvalidColumnIndex_ThrowsIndexOutOfBoundsException()
    {
        // Arrange
        Map map = new Map(1);
        Coordinate coord = new Coordinate(0,1);

        // Act & Assert
        assertThatThrownBy(() -> map.getField(coord))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void getField_GivenInvalidRowAndColumnIndex_ThrowsIndexOutOfBoundsException()
    {
        // Arrange
        Map map = new Map(1);
        Coordinate coord = new Coordinate(1,1);

        // Act & Assert
        assertThatThrownBy(() -> map.getField(coord))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void getField_GivenValidIndex_WhenMapIsEmpty_ReturnsWaterField()
    {
        // Arrange
        Map map = new Map(2);
        Coordinate coord = new Coordinate(1, 1);

        // Act
        Field field = map.getField(coord);

        // Assert
        assertThat(field).isEqualTo(Field.Water);
    }

    @Test
    void newMap_WhenEmpty_IsFilledWithWaterFields()
    {
        // Arrange
        int size = 4;
        List<Field> mapFields = new ArrayList<Field>();

        // Act
        Map map = new Map(size);

        // Assert
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                Coordinate coord = new Coordinate(x, y);
                mapFields.add(map.getField(coord));
            }
        }

        assertThat(mapFields).containsOnly(Field.Water);
    }

    @Test
    void newMap_WithLandAndSize10_Contains10LandFields()
    {
        // Arrange
        int size = 10;
        List<Field> landFields = new ArrayList<Field>();

        // Act
        Map map = new Map(size, true);

        // Assert
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                Coordinate coord = new Coordinate(x, y);
                if (map.getField(coord) == Field.Land)
                {
                    landFields.add(map.getField(coord));
                }
            }
        }

        assertThat(landFields).hasSize(10);
    }
}
