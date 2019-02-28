package thk.fae.ua.core.util.google;

/*
 * Copyright 2014 Google Inc. All rights reserved.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF
 * ANY KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

        import java.io.Serializable;
        import java.util.Locale;
        import java.util.Objects;

/** A place on Earth, represented by a latitude/longitude pair. */
public class LatLng implements Serializable {

    private static final long serialVersionUID = 1L;

    /** The latitude of this location. */
    public double latitude;

    /** The longitude of this location. */
    public double longitude;

    /**
     * Constructs a location with a latitude/longitude pair.
     *
     * @param latitude The latitude of this location.
     * @param longitude The longitude of this location.
     */
    public LatLng(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /** Serialisation constructor. */
    public LatLng() {}

    @Override
    public String toString() {
        return toUrlValue();
    }

    public String toUrlValue() {
        // Enforce Locale to English for double to string conversion
        return String.format(Locale.ENGLISH, "%.8f,%.8f", latitude, longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LatLng latLng = (LatLng) o;
        return Double.compare(latLng.latitude, latitude) == 0 && Double.compare(latLng.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}