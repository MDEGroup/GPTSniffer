public static double sumAreas(GeometricObject[] arr) {
    double sum = 0;
    for (GeometricObject obj : arr) {
        sum += obj.getArea();
    }
    return sum;
}
