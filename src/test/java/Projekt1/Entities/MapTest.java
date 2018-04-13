package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MapTest
{
    @Test
    void getFieldGivenInvalidRowIndexThrowsIndexOutOfBoundsException()
    {
        // Arrange
        Map map = new Map(1);
        Coordinate c = new Coordinate(1,0);

        // Act & Assert
        assertThatThrownBy(() -> map.getField(c))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void getFieldGivenInvalidColumnIndexThrowsIndexOutOfBoundsException()
    {
        // Arrange
        Map map = new Map(1);
        Coordinate c = new Coordinate(0,1);

        // Act & Assert
        assertThatThrownBy(() -> map.getField(c))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void getFieldGivenInvalidRowAndColumnIndexThrowsIndexOutOfBoundsException()
    {
        // Arrange
        Map map = new Map(1);
        Coordinate c = new Coordinate(1,1);

        // Act & Assert
        assertThatThrownBy(() -> map.getField(c))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void getFieldGivenValidIndexWhenMapIsEmptyReturnsWaterField()
    {
        // Arrange
        Map map = new Map(2);
        Coordinate c = new Coordinate(1, 1);

        // Act
        Field field = map.getField(c);

        // Assert
        assertThat(field).isEqualTo(Field.Water);
    }

    @Test
    void newMapWhenEmptyIsFilledWithWaterFields()
    {
        // Arrange
        int size = 4;
        List<Field> mapFields = new ArrayList<>();

        // Act
        Map map = new Map(size);

        // Assert
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                Coordinate c = new Coordinate(x, y);
                mapFields.add(map.getField(c));
            }
        }

        assertThat(mapFields).containsOnly(Field.Water);
    }

    @Test
    void newMapWithLandAndSize10Contains10LandFields()
    {
        // Arrange
        int size = 10;
        List<Field> landFields = new ArrayList<>();

        // Act
        Map map = new Map(size, true);

        // Assert
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                Coordinate c = new Coordinate(x, y);
                if (map.getField(c) == Field.Land)
                {
                    landFields.add(map.getField(c));
                }
            }
        }

        assertThat(landFields).hasSize(10);
    }
}
