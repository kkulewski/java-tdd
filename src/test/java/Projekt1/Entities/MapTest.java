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
        Map map = new Map(size);
        List<Field> mapFields = new ArrayList<Field>();

        // Act
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                mapFields.add(map.getField(i, j));
            }
        }

        // Assert
        assertThat(mapFields).containsOnly(Field.Water);
    }
}
