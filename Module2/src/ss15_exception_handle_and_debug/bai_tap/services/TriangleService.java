package ss15_exception_handle_and_debug.bai_tap.services;

import ss15_exception_handle_and_debug.bai_tap.common.exception.IllegalTriangleException;

public class TriangleService implements ITriangle{
    @Override
    public boolean checkIllegalTriangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 + side2 <= side3 || side2 + side3 <= side1 || side1 + side3 <= side2 || side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalTriangleException("Not a triangle!!!");
        }
        return true;
    }
}
