package Projekt1.Entities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void newMap_WhenEmpty_IsFilledWithWaterFields()
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
                mapFields.add(map.getField(x, y));
            }
        }

        assertThat(mapFields).containsOnly(Field.Water);
    }

    @Test
    public void newMap_WithLandAndSize10_Contains10LandFields()
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
                if (map.getField(x, y) == Field.Land)
                {
                    landFields.add(map.getField(x, y));
                }
            }
        }

        assertThat(landFields).hasSize(10);
    }
}
