package case_study_accu.entity;

public class CurrentWeather {
    private String LocalObservationDateTime;
    private long EpochTime;
    private String WeatherText;
    private int WeatherIcon;
    private boolean HasPrecipitation;
    private String PrecipitationType;
    private boolean IsDayTime;

    private TemperatureWrapper Temperature;
    private TemperatureWrapper RealFeelTemperature;
    private TemperatureWrapper RealFeelTemperatureShade;
    private int RelativeHumidity;
    private Integer IndoorRelativeHumidity;
    private TemperatureWrapper DewPoint;
    private WindWrapper Wind;
    private WindGustWrapper WindGust;
    private int UVIndex;
    private double UVIndexFloat;
    private String UVIndexText;
    private TemperatureWrapper Visibility;
    private String ObstructionsToVisibility;
    private int CloudCover;
    private TemperatureWrapper Ceiling;
    private TemperatureWrapper Pressure;
    private PressureTendencyWrapper PressureTendency;
    private PrecipitationSummaryWrapper Past24HourTemperatureDeparture;
    private TemperatureWrapper ApparentTemperature;
    private TemperatureWrapper WindChillTemperature;
    private TemperatureWrapper WetBulbTemperature;
    private TemperatureWrapper WetBulbGlobeTemperature;
    private PrecipitationWrapper Precip1hr;
    private PrecipitationSummaryWrapper PrecipitationSummary;
    private TemperatureSummaryWrapper TemperatureSummary;
    private String MobileLink;
    private String Link;

    public String getLocalObservationDateTime() {
        return LocalObservationDateTime;
    }

    public void setLocalObservationDateTime(String localObservationDateTime) {
        LocalObservationDateTime = localObservationDateTime;
    }

    public long getEpochTime() {
        return EpochTime;
    }

    public void setEpochTime(long epochTime) {
        EpochTime = epochTime;
    }

    public String getWeatherText() {
        return WeatherText;
    }

    public void setWeatherText(String weatherText) {
        WeatherText = weatherText;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }

    public String getPrecipitationType() {
        return PrecipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        PrecipitationType = precipitationType;
    }

    public boolean isDayTime() {
        return IsDayTime;
    }

    public void setDayTime(boolean dayTime) {
        IsDayTime = dayTime;
    }

    public TemperatureWrapper getTemperature() {
        return Temperature;
    }

    public void setTemperature(TemperatureWrapper temperature) {
        Temperature = temperature;
    }

    public TemperatureWrapper getRealFeelTemperature() {
        return RealFeelTemperature;
    }

    public void setRealFeelTemperature(TemperatureWrapper realFeelTemperature) {
        RealFeelTemperature = realFeelTemperature;
    }

    public TemperatureWrapper getRealFeelTemperatureShade() {
        return RealFeelTemperatureShade;
    }

    public void setRealFeelTemperatureShade(TemperatureWrapper realFeelTemperatureShade) {
        RealFeelTemperatureShade = realFeelTemperatureShade;
    }

    public int getRelativeHumidity() {
        return RelativeHumidity;
    }

    public void setRelativeHumidity(int relativeHumidity) {
        RelativeHumidity = relativeHumidity;
    }

    public Integer getIndoorRelativeHumidity() {
        return IndoorRelativeHumidity;
    }

    public void setIndoorRelativeHumidity(Integer indoorRelativeHumidity) {
        IndoorRelativeHumidity = indoorRelativeHumidity;
    }

    public TemperatureWrapper getDewPoint() {
        return DewPoint;
    }

    public void setDewPoint(TemperatureWrapper dewPoint) {
        DewPoint = dewPoint;
    }

    public WindWrapper getWind() {
        return Wind;
    }

    public void setWind(WindWrapper wind) {
        Wind = wind;
    }

    public WindGustWrapper getWindGust() {
        return WindGust;
    }

    public void setWindGust(WindGustWrapper windGust) {
        WindGust = windGust;
    }

    public int getUVIndex() {
        return UVIndex;
    }

    public void setUVIndex(int UVIndex) {
        this.UVIndex = UVIndex;
    }

    public double getUVIndexFloat() {
        return UVIndexFloat;
    }

    public void setUVIndexFloat(double UVIndexFloat) {
        this.UVIndexFloat = UVIndexFloat;
    }

    public String getUVIndexText() {
        return UVIndexText;
    }

    public void setUVIndexText(String UVIndexText) {
        this.UVIndexText = UVIndexText;
    }

    public TemperatureWrapper getVisibility() {
        return Visibility;
    }

    public void setVisibility(TemperatureWrapper visibility) {
        Visibility = visibility;
    }

    public String getObstructionsToVisibility() {
        return ObstructionsToVisibility;
    }

    public void setObstructionsToVisibility(String obstructionsToVisibility) {
        ObstructionsToVisibility = obstructionsToVisibility;
    }

    public int getCloudCover() {
        return CloudCover;
    }

    public void setCloudCover(int cloudCover) {
        CloudCover = cloudCover;
    }

    public TemperatureWrapper getCeiling() {
        return Ceiling;
    }

    public void setCeiling(TemperatureWrapper ceiling) {
        Ceiling = ceiling;
    }

    public TemperatureWrapper getPressure() {
        return Pressure;
    }

    public void setPressure(TemperatureWrapper pressure) {
        Pressure = pressure;
    }

    public PressureTendencyWrapper getPressureTendency() {
        return PressureTendency;
    }

    public void setPressureTendency(PressureTendencyWrapper pressureTendency) {
        PressureTendency = pressureTendency;
    }

    public PrecipitationSummaryWrapper getPast24HourTemperatureDeparture() {
        return Past24HourTemperatureDeparture;
    }

    public void setPast24HourTemperatureDeparture(PrecipitationSummaryWrapper past24HourTemperatureDeparture) {
        Past24HourTemperatureDeparture = past24HourTemperatureDeparture;
    }

    public TemperatureWrapper getApparentTemperature() {
        return ApparentTemperature;
    }

    public void setApparentTemperature(TemperatureWrapper apparentTemperature) {
        ApparentTemperature = apparentTemperature;
    }

    public TemperatureWrapper getWindChillTemperature() {
        return WindChillTemperature;
    }

    public void setWindChillTemperature(TemperatureWrapper windChillTemperature) {
        WindChillTemperature = windChillTemperature;
    }

    public TemperatureWrapper getWetBulbTemperature() {
        return WetBulbTemperature;
    }

    public void setWetBulbTemperature(TemperatureWrapper wetBulbTemperature) {
        WetBulbTemperature = wetBulbTemperature;
    }

    public TemperatureWrapper getWetBulbGlobeTemperature() {
        return WetBulbGlobeTemperature;
    }

    public void setWetBulbGlobeTemperature(TemperatureWrapper wetBulbGlobeTemperature) {
        WetBulbGlobeTemperature = wetBulbGlobeTemperature;
    }

    public PrecipitationWrapper getPrecip1hr() {
        return Precip1hr;
    }

    public void setPrecip1hr(PrecipitationWrapper precip1hr) {
        Precip1hr = precip1hr;
    }

    public PrecipitationSummaryWrapper getPrecipitationSummary() {
        return PrecipitationSummary;
    }

    public void setPrecipitationSummary(PrecipitationSummaryWrapper precipitationSummary) {
        PrecipitationSummary = precipitationSummary;
    }

    public TemperatureSummaryWrapper getTemperatureSummary() {
        return TemperatureSummary;
    }

    public void setTemperatureSummary(TemperatureSummaryWrapper temperatureSummary) {
        TemperatureSummary = temperatureSummary;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public void setMobileLink(String mobileLink) {
        MobileLink = mobileLink;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public static class TemperatureWrapper {
        private UnitMetric Metric;
        private UnitMetric Imperial;

        public UnitMetric getMetric() {
            return Metric;
        }

        public void setMetric(UnitMetric metric) {
            Metric = metric;
        }

        public UnitMetric getImperial() {
            return Imperial;
        }

        public void setImperial(UnitMetric imperial) {
            Imperial = imperial;
        }

        @Override
        public String toString() {
            return "TemperatureWrapper{" +
                    "Metric=" + Metric +
                    ", Imperial=" + Imperial +
                    '}';
        }
    }

    public static class UnitMetric {
        private double Value;
        private String Unit;
        private int UnitType;
        private String Phrase;

        public double getValue() {
            return Value;
        }

        public void setValue(double value) {
            Value = value;
        }

        public String getUnit() {
            return Unit;
        }

        public void setUnit(String unit) {
            Unit = unit;
        }

        public int getUnitType() {
            return UnitType;
        }

        public void setUnitType(int unitType) {
            UnitType = unitType;
        }

        public String getPhrase() {
            return Phrase;
        }

        public void setPhrase(String phrase) {
            Phrase = phrase;
        }
    }

    public static class WindWrapper {
        private Direction Direction;
        private SpeedWrapper Speed;

        public Direction getDirection() {
            return Direction;
        }

        public void setDirection(Direction direction) {
            Direction = direction;
        }

        public SpeedWrapper getSpeed() {
            return Speed;
        }

        public void setSpeed(SpeedWrapper speed) {
            Speed = speed;
        }
    }

    public static class WindGustWrapper {
        private SpeedWrapper Speed;

        public SpeedWrapper getSpeed() {
            return Speed;
        }

        public void setSpeed(SpeedWrapper speed) {
            Speed = speed;
        }
    }

    public static class SpeedWrapper {
        private UnitMetric Metric;
        private UnitMetric Imperial;

        public UnitMetric getMetric() {
            return Metric;
        }

        public void setMetric(UnitMetric metric) {
            Metric = metric;
        }

        public UnitMetric getImperial() {
            return Imperial;
        }

        public void setImperial(UnitMetric imperial) {
            Imperial = imperial;
        }
    }

    public static class Direction {
        private int Degrees;
        private String Localized;
        private String English;

        public int getDegrees() {
            return Degrees;
        }

        public void setDegrees(int degrees) {
            Degrees = degrees;
        }

        public String getLocalized() {
            return Localized;
        }

        public void setLocalized(String localized) {
            Localized = localized;
        }

        public String getEnglish() {
            return English;
        }

        public void setEnglish(String english) {
            English = english;
        }
    }

    public static class PressureTendencyWrapper {
        private String LocalizedText;
        private String Code;

        public String getLocalizedText() {
            return LocalizedText;
        }

        public void setLocalizedText(String localizedText) {
            LocalizedText = localizedText;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String code) {
            Code = code;
        }
    }

    public static class PrecipitationWrapper {
        private UnitMetric Metric;
        private UnitMetric Imperial;

        public UnitMetric getMetric() {
            return Metric;
        }

        public void setMetric(UnitMetric metric) {
            Metric = metric;
        }

        public UnitMetric getImperial() {
            return Imperial;
        }

        public void setImperial(UnitMetric imperial) {
            Imperial = imperial;
        }
    }

    public static class PrecipitationSummaryWrapper {
        private PrecipitationWrapper Precipitation;
        private PrecipitationWrapper PastHour;
        private PrecipitationWrapper Past3Hours;
        private PrecipitationWrapper Past6Hours;
        private PrecipitationWrapper Past9Hours;
        private PrecipitationWrapper Past12Hours;
        private PrecipitationWrapper Past18Hours;
        private PrecipitationWrapper Past24Hours;

        public PrecipitationWrapper getPrecipitation() {
            return Precipitation;
        }

        public void setPrecipitation(PrecipitationWrapper precipitation) {
            Precipitation = precipitation;
        }

        public PrecipitationWrapper getPastHour() {
            return PastHour;
        }

        public void setPastHour(PrecipitationWrapper pastHour) {
            PastHour = pastHour;
        }

        public PrecipitationWrapper getPast3Hours() {
            return Past3Hours;
        }

        public void setPast3Hours(PrecipitationWrapper past3Hours) {
            Past3Hours = past3Hours;
        }

        public PrecipitationWrapper getPast6Hours() {
            return Past6Hours;
        }

        public void setPast6Hours(PrecipitationWrapper past6Hours) {
            Past6Hours = past6Hours;
        }

        public PrecipitationWrapper getPast9Hours() {
            return Past9Hours;
        }

        public void setPast9Hours(PrecipitationWrapper past9Hours) {
            Past9Hours = past9Hours;
        }

        public PrecipitationWrapper getPast12Hours() {
            return Past12Hours;
        }

        public void setPast12Hours(PrecipitationWrapper past12Hours) {
            Past12Hours = past12Hours;
        }

        public PrecipitationWrapper getPast18Hours() {
            return Past18Hours;
        }

        public void setPast18Hours(PrecipitationWrapper past18Hours) {
            Past18Hours = past18Hours;
        }

        public PrecipitationWrapper getPast24Hours() {
            return Past24Hours;
        }

        public void setPast24Hours(PrecipitationWrapper past24Hours) {
            Past24Hours = past24Hours;
        }
    }

    public static class TemperatureSummaryWrapper {
        private RangeWrapper Past6HourRange;
        private RangeWrapper Past12HourRange;
        private RangeWrapper Past24HourRange;

        public RangeWrapper getPast6HourRange() {
            return Past6HourRange;
        }

        public void setPast6HourRange(RangeWrapper past6HourRange) {
            Past6HourRange = past6HourRange;
        }

        public RangeWrapper getPast12HourRange() {
            return Past12HourRange;
        }

        public void setPast12HourRange(RangeWrapper past12HourRange) {
            Past12HourRange = past12HourRange;
        }

        public RangeWrapper getPast24HourRange() {
            return Past24HourRange;
        }

        public void setPast24HourRange(RangeWrapper past24HourRange) {
            Past24HourRange = past24HourRange;
        }
    }

    public static class RangeWrapper {
        private UnitMetric Minimum;
        private UnitMetric Maximum;

        public UnitMetric getMinimum() {
            return Minimum;
        }

        public void setMinimum(UnitMetric minimum) {
            Minimum = minimum;
        }

        public UnitMetric getMaximum() {
            return Maximum;
        }

        public void setMaximum(UnitMetric maximum) {
            Maximum = maximum;
        }
    }

    @Override
    public String toString() {
        return "CurrentWeather{\n" +
                "LocalObservationDateTime='" + LocalObservationDateTime + '\'' +
                ", EpochTime=" + EpochTime +
                ", WeatherText='" + WeatherText + '\'' +
                ", WeatherIcon=" + WeatherIcon +
                ", HasPrecipitation=" + HasPrecipitation +
                ", PrecipitationType='" + PrecipitationType + '\'' +
                ", IsDayTime=" + IsDayTime +
                ", Temperature=" + Temperature +
                ", RealFeelTemperature=" + RealFeelTemperature +
                ", RealFeelTemperatureShade=" + RealFeelTemperatureShade +
                ", RelativeHumidity=" + RelativeHumidity +
                ", IndoorRelativeHumidity=" + IndoorRelativeHumidity +
                ", DewPoint=" + DewPoint +
                ", Wind=" + Wind +
                ", WindGust=" + WindGust +
                ", UVIndex=" + UVIndex +
                ", UVIndexFloat=" + UVIndexFloat +
                ", UVIndexText='" + UVIndexText + '\'' +
                ", Visibility=" + Visibility +
                ", ObstructionsToVisibility='" + ObstructionsToVisibility + '\'' +
                ", CloudCover=" + CloudCover +
                ", Ceiling=" + Ceiling +
                ", Pressure=" + Pressure +
                ", PressureTendency=" + PressureTendency +
                ", Past24HourTemperatureDeparture=" + Past24HourTemperatureDeparture +
                ", ApparentTemperature=" + ApparentTemperature +
                ", WindChillTemperature=" + WindChillTemperature +
                ", WetBulbTemperature=" + WetBulbTemperature +
                ", WetBulbGlobeTemperature=" + WetBulbGlobeTemperature +
                ", Precip1hr=" + Precip1hr +
                ", PrecipitationSummary=" + PrecipitationSummary +
                ", TemperatureSummary=" + TemperatureSummary +
                ", MobileLink='" + MobileLink + '\'' +
                ", Link='" + Link + '\'' +
                '}';
    }
}
