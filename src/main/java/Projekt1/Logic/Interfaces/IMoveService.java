package Projekt1.Logic.Interfaces;

public interface IMoveService
{
    public IActionResult turnRight();
    public IActionResult turnLeft();
    public IActionResult moveForward();
    public IActionResult moveBack();
    public IActionResult shoot();
}
