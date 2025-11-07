package case_study_accu.entity;

import java.util.List;

public class OneDayForecast {

    private Headline Headline;
    private List<DailyForecast> DailyForecasts;
    public Headline getHeadline() { return Headline; }
    public void setHeadline(Headline headline) { Headline = headline; }

    public List<DailyForecast> getDailyForecasts() { return DailyForecasts; }
    public void setDailyForecasts(List<DailyForecast> dailyForecasts) { DailyForecasts = dailyForecasts; }

    // ======= Inner Classes =======

    public static class Headline {
        private String EffectiveDate;
        private long EffectiveEpochDate;
        private int Severity;
        private String Text;
        private String Category;
        private String EndDate;
        private long EndEpochDate;
        private String MobileLink;
        private String Link;

        public String getText() { return Text; }
    }

    public static class DailyForecast {
        private String Date;
        private long EpochDate;
        private Sun Sun;
        private Moon Moon;
        private Temperature Temperature;
        private RealFeelTemperature RealFeelTemperature;
        private RealFeelTemperature RealFeelTemperatureShade;
        private double HoursOfSun;
        private DegreeDaySummary DegreeDaySummary;
        private List<AirAndPollen> AirAndPollen;
        private DayPart Day;
        private DayPart Night;
        private List<String> Sources;
        private String MobileLink;
        private String Link;

        public String getDate() { return Date; }
        public Temperature getTemperature() { return Temperature; }
        public RealFeelTemperature getRealFeelTemperature() { return RealFeelTemperature; }
        public RealFeelTemperature getRealFeelTemperatureShade() { return RealFeelTemperatureShade; }
        public DayPart getDay() { return Day; }

        public List<AirAndPollen> getAirAndPollen() {
            return AirAndPollen;
        }

        public void setAirAndPollen(List<AirAndPollen> airAndPollen) {
            AirAndPollen = airAndPollen;
        }

        public long getEpochDate() {
            return EpochDate;
        }

        public Sun getSun() {
            return Sun;
        }

        public Moon getMoon() {
            return Moon;
        }

        public double getHoursOfSun() {
            return HoursOfSun;
        }

        public DegreeDaySummary getDegreeDaySummary() {
            return DegreeDaySummary;
        }

        public DayPart getNight() {
            return Night;
        }

        public List<String> getSources() {
            return Sources;
        }

        public String getMobileLink() {
            return MobileLink;
        }

        public String getLink() {
            return Link;
        }
    }

    public static class Sun {
        private String Rise;
        private String Set;
    }

    public static class Moon {
        private String Rise;
        private String Set;
        private String Phase;
        private int Age;
    }

    public static class Temperature {
        private Value Minimum;
        private Value Maximum;

        public Value getMinimum() { return Minimum; }
        public Value getMaximum() { return Maximum; }
    }

    public static class RealFeelTemperature {
        private Value Minimum;
        private Value Maximum;

        public Value getMinimum() { return Minimum; }
        public Value getMaximum() { return Maximum; }
    }

    public static class DegreeDaySummary {
        private Value Heating;
        private Value Cooling;
    }

    public static class AirAndPollen {
        private String Name;
        private int Value;
        private String Category;
        private int CategoryValue;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public int getValue() {
            return Value;
        }

        public String getCategory() {
            return Category;
        }
    }

    public static class DayPart {
        private int Icon;
        private String IconPhrase;
        private boolean HasPrecipitation;
        private String PrecipitationType;
        private String PrecipitationIntensity;
        private String ShortPhrase;
        private String LongPhrase;
        private int PrecipitationProbability;
        private int ThunderstormProbability;
        private int RainProbability;
        private Wind Wind;
        private Wind WindGust;
        private Value TotalLiquid;
        private Value Rain;
        private double HoursOfPrecipitation;
        private double HoursOfRain;
        private int CloudCover;

        public String getIconPhrase() { return IconPhrase; }
        public String getShortPhrase() { return ShortPhrase; }
        public Wind getWind() { return Wind; }
        public Value getRain() { return Rain; }
        public int getCloudCover() { return CloudCover; }

        public String getLongPhrase() {
            return LongPhrase;
        }

        public void setLongPhrase(String longPhrase) {
            LongPhrase = longPhrase;
        }

        public Wind getWindGust() {
            return WindGust;
        }

        public int getPrecipitationProbability() {
            return PrecipitationProbability;
        }

        public int getThunderstormProbability() {
            return ThunderstormProbability;
        }

        public Value getTotalLiquid() {
            return TotalLiquid;
        }

        public int getIcon() {
            return Icon;
        }

        public boolean isHasPrecipitation() {
            return HasPrecipitation;
        }

        public String getPrecipitationType() {
            return PrecipitationType;
        }

        public String getPrecipitationIntensity() {
            return PrecipitationIntensity;
        }

        public int getRainProbability() {
            return RainProbability;
        }

        public double getHoursOfPrecipitation() {
            return HoursOfPrecipitation;
        }

        public double getHoursOfRain() {
            return HoursOfRain;
        }
    }

    public static class Wind {
        private Speed Speed;
        private Direction Direction;

        public Speed getSpeed() { return Speed; }
        public Direction getDirection() { return Direction; }
    }

    public static class Speed {
        private double Value;
        private String Unit;

        public double getValue() { return Value; }
        public String getUnit() { return Unit; }
    }

    public static class Direction {
        private int Degrees;
        private String Localized;
        private String English;

        public String getLocalized() { return Localized; }
    }

    public static class Value {
        private double Value;
        private String Unit;
        private int UnitType;
        private String Phrase;

        public double getValue() { return Value; }
        public String getUnit() { return Unit; }
        public String getPhrase() { return Phrase; }
    }
}
