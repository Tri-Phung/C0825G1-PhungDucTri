package case_study_accu.entity;

import java.util.List;

public class FiveDayForecast {

    private Headline Headline;
    private List<DailyForecast> DailyForecasts;

    // Getter & Setter
    public Headline getHeadline() {
        return Headline;
    }

    public void setHeadline(Headline headline) {
        Headline = headline;
    }

    public List<DailyForecast> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }

    // ================== Inner Classes ==================

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

        // Getter & Setter
        public String getEffectiveDate() { return EffectiveDate; }
        public void setEffectiveDate(String effectiveDate) { EffectiveDate = effectiveDate; }

        public long getEffectiveEpochDate() { return EffectiveEpochDate; }
        public void setEffectiveEpochDate(long effectiveEpochDate) { EffectiveEpochDate = effectiveEpochDate; }

        public int getSeverity() { return Severity; }
        public void setSeverity(int severity) { Severity = severity; }

        public String getText() { return Text; }
        public void setText(String text) { Text = text; }

        public String getCategory() { return Category; }
        public void setCategory(String category) { Category = category; }

        public String getEndDate() { return EndDate; }
        public void setEndDate(String endDate) { EndDate = endDate; }

        public long getEndEpochDate() { return EndEpochDate; }
        public void setEndEpochDate(long endEpochDate) { EndEpochDate = endEpochDate; }

        public String getMobileLink() { return MobileLink; }
        public void setMobileLink(String mobileLink) { MobileLink = mobileLink; }

        public String getLink() { return Link; }
        public void setLink(String link) { Link = link; }
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
        private DayNight Day;
        private DayNight Night;
        private List<String> Sources;
        private String MobileLink;
        private String Link;

        // Getter & Setter
        public String getDate() { return Date; }
        public void setDate(String date) { Date = date; }

        public long getEpochDate() { return EpochDate; }
        public void setEpochDate(long epochDate) { EpochDate = epochDate; }

        public Sun getSun() { return Sun; }
        public void setSun(Sun sun) { Sun = sun; }

        public Moon getMoon() { return Moon; }
        public void setMoon(Moon moon) { Moon = moon; }

        public Temperature getTemperature() { return Temperature; }
        public void setTemperature(Temperature temperature) { Temperature = temperature; }

        public RealFeelTemperature getRealFeelTemperature() { return RealFeelTemperature; }
        public void setRealFeelTemperature(RealFeelTemperature realFeelTemperature) { RealFeelTemperature = realFeelTemperature; }

        public RealFeelTemperature getRealFeelTemperatureShade() { return RealFeelTemperatureShade; }
        public void setRealFeelTemperatureShade(RealFeelTemperature realFeelTemperatureShade) { RealFeelTemperatureShade = realFeelTemperatureShade; }

        public double getHoursOfSun() { return HoursOfSun; }
        public void setHoursOfSun(double hoursOfSun) { HoursOfSun = hoursOfSun; }

        public DegreeDaySummary getDegreeDaySummary() { return DegreeDaySummary; }
        public void setDegreeDaySummary(DegreeDaySummary degreeDaySummary) { DegreeDaySummary = degreeDaySummary; }

        public List<AirAndPollen> getAirAndPollen() { return AirAndPollen; }
        public void setAirAndPollen(List<AirAndPollen> airAndPollen) { AirAndPollen = airAndPollen; }

        public DayNight getDay() { return Day; }
        public void setDay(DayNight day) { Day = day; }

        public DayNight getNight() { return Night; }
        public void setNight(DayNight night) { Night = night; }

        public List<String> getSources() { return Sources; }
        public void setSources(List<String> sources) { Sources = sources; }

        public String getMobileLink() { return MobileLink; }
        public void setMobileLink(String mobileLink) { MobileLink = mobileLink; }

        public String getLink() { return Link; }
        public void setLink(String link) { Link = link; }
    }

    // --- Subclasses for nested structures ---

    public static class Sun {
        private String Rise;
        private long EpochRise;
        private String Set;
        private long EpochSet;
        // Getter & Setter
        public String getRise() { return Rise; }
        public void setRise(String rise) { Rise = rise; }
        public long getEpochRise() { return EpochRise; }
        public void setEpochRise(long epochRise) { EpochRise = epochRise; }
        public String getSet() { return Set; }
        public void setSet(String set) { Set = set; }
        public long getEpochSet() { return EpochSet; }
        public void setEpochSet(long epochSet) { EpochSet = epochSet; }
    }

    public static class Moon {
        private String Rise;
        private long EpochRise;
        private String Set;
        private long EpochSet;
        private String Phase;
        private int Age;
        // Getter & Setter
        public String getRise() { return Rise; }
        public void setRise(String rise) { Rise = rise; }
        public long getEpochRise() { return EpochRise; }
        public void setEpochRise(long epochRise) { EpochRise = epochRise; }
        public String getSet() { return Set; }
        public void setSet(String set) { Set = set; }
        public long getEpochSet() { return EpochSet; }
        public void setEpochSet(long epochSet) { EpochSet = epochSet; }
        public String getPhase() { return Phase; }
        public void setPhase(String phase) { Phase = phase; }
        public int getAge() { return Age; }
        public void setAge(int age) { Age = age; }
    }

    public static class Temperature {
        private TemperatureValue Minimum;
        private TemperatureValue Maximum;
        // Getter & Setter
        public TemperatureValue getMinimum() { return Minimum; }
        public void setMinimum(TemperatureValue minimum) { Minimum = minimum; }
        public TemperatureValue getMaximum() { return Maximum; }
        public void setMaximum(TemperatureValue maximum) { Maximum = maximum; }
    }

    public static class TemperatureValue {
        private double Value;
        private String Unit;
        private int UnitType;
        private String Phrase; // Có thể có hoặc không
        // Getter & Setter
        public double getValue() { return Value; }
        public void setValue(double value) { Value = value; }
        public String getUnit() { return Unit; }
        public void setUnit(String unit) { Unit = unit; }
        public int getUnitType() { return UnitType; }
        public void setUnitType(int unitType) { UnitType = unitType; }
        public String getPhrase() { return Phrase; }
        public void setPhrase(String phrase) { Phrase = phrase; }
    }

    public static class RealFeelTemperature {
        private TemperatureValue Minimum;
        private TemperatureValue Maximum;
        public TemperatureValue getMinimum() { return Minimum; }
        public void setMinimum(TemperatureValue minimum) { Minimum = minimum; }
        public TemperatureValue getMaximum() { return Maximum; }
        public void setMaximum(TemperatureValue maximum) { Maximum = maximum; }
    }

    public static class DegreeDaySummary {
        private TemperatureValue Heating;
        private TemperatureValue Cooling;
        public TemperatureValue getHeating() { return Heating; }
        public void setHeating(TemperatureValue heating) { Heating = heating; }
        public TemperatureValue getCooling() { return Cooling; }
        public void setCooling(TemperatureValue cooling) { Cooling = cooling; }
    }

    public static class AirAndPollen {
        private String Name;
        private int Value;
        private String Category;
        private int CategoryValue;
        private String Type;
        // Getter & Setter
        public String getName() { return Name; }
        public void setName(String name) { Name = name; }
        public int getValue() { return Value; }
        public void setValue(int value) { Value = value; }
        public String getCategory() { return Category; }
        public void setCategory(String category) { Category = category; }
        public int getCategoryValue() { return CategoryValue; }
        public void setCategoryValue(int categoryValue) { CategoryValue = categoryValue; }
        public String getType() { return Type; }
        public void setType(String type) { Type = type; }
    }

    public static class DayNight {
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
        private int SnowProbability;
        private int IceProbability;
        private Wind Wind;
        private Wind WindGust;
        private TemperatureValue TotalLiquid;
        private TemperatureValue Rain;
        private TemperatureValue Snow;
        private TemperatureValue Ice;
        private double HoursOfPrecipitation;
        private double HoursOfRain;
        private double HoursOfSnow;
        private double HoursOfIce;
        private int CloudCover;

        // Getter & Setter
        public int getIcon() { return Icon; }
        public void setIcon(int icon) { Icon = icon; }
        public String getIconPhrase() { return IconPhrase; }
        public void setIconPhrase(String iconPhrase) { IconPhrase = iconPhrase; }
        public boolean isHasPrecipitation() { return HasPrecipitation; }
        public void setHasPrecipitation(boolean hasPrecipitation) { HasPrecipitation = hasPrecipitation; }
        public String getPrecipitationType() { return PrecipitationType; }
        public void setPrecipitationType(String precipitationType) { PrecipitationType = precipitationType; }
        public String getPrecipitationIntensity() { return PrecipitationIntensity; }
        public void setPrecipitationIntensity(String precipitationIntensity) { PrecipitationIntensity = precipitationIntensity; }
        public String getShortPhrase() { return ShortPhrase; }
        public void setShortPhrase(String shortPhrase) { ShortPhrase = shortPhrase; }
        public String getLongPhrase() { return LongPhrase; }
        public void setLongPhrase(String longPhrase) { LongPhrase = longPhrase; }
        public int getPrecipitationProbability() { return PrecipitationProbability; }
        public void setPrecipitationProbability(int precipitationProbability) { PrecipitationProbability = precipitationProbability; }
        public int getThunderstormProbability() { return ThunderstormProbability; }
        public void setThunderstormProbability(int thunderstormProbability) { ThunderstormProbability = thunderstormProbability; }
        public int getRainProbability() { return RainProbability; }
        public void setRainProbability(int rainProbability) { RainProbability = rainProbability; }
        public int getSnowProbability() { return SnowProbability; }
        public void setSnowProbability(int snowProbability) { SnowProbability = snowProbability; }
        public int getIceProbability() { return IceProbability; }
        public void setIceProbability(int iceProbability) { IceProbability = iceProbability; }
        public Wind getWind() { return Wind; }
        public void setWind(Wind wind) { Wind = wind; }
        public Wind getWindGust() { return WindGust; }
        public void setWindGust(Wind windGust) { WindGust = windGust; }
        public TemperatureValue getTotalLiquid() { return TotalLiquid; }
        public void setTotalLiquid(TemperatureValue totalLiquid) { TotalLiquid = totalLiquid; }
        public TemperatureValue getRain() { return Rain; }
        public void setRain(TemperatureValue rain) { Rain = rain; }
        public TemperatureValue getSnow() { return Snow; }
        public void setSnow(TemperatureValue snow) { Snow = snow; }
        public TemperatureValue getIce() { return Ice; }
        public void setIce(TemperatureValue ice) { Ice = ice; }
        public double getHoursOfPrecipitation() { return HoursOfPrecipitation; }
        public void setHoursOfPrecipitation(double hoursOfPrecipitation) { HoursOfPrecipitation = hoursOfPrecipitation; }
        public double getHoursOfRain() { return HoursOfRain; }
        public void setHoursOfRain(double hoursOfRain) { HoursOfRain = hoursOfRain; }
        public double getHoursOfSnow() { return HoursOfSnow; }
        public void setHoursOfSnow(double hoursOfSnow) { HoursOfSnow = hoursOfSnow; }
        public double getHoursOfIce() { return HoursOfIce; }
        public void setHoursOfIce(double hoursOfIce) { HoursOfIce = hoursOfIce; }
        public int getCloudCover() { return CloudCover; }
        public void setCloudCover(int cloudCover) { CloudCover = cloudCover; }
    }

    public static class Wind {
        private Speed Speed;
        private Direction Direction;
        public Speed getSpeed() { return Speed; }
        public void setSpeed(Speed speed) { Speed = speed; }
        public Direction getDirection() { return Direction; }
        public void setDirection(Direction direction) { Direction = direction; }
    }

    public static class Speed {
        private double Value;
        private String Unit;
        private int UnitType;
        public double getValue() { return Value; }
        public void setValue(double value) { Value = value; }
        public String getUnit() { return Unit; }
        public void setUnit(String unit) { Unit = unit; }
        public int getUnitType() { return UnitType; }
        public void setUnitType(int unitType) { UnitType = unitType; }
    }

    public static class Direction {
        private int Degrees;
        private String Localized;
        private String English;
        public int getDegrees() { return Degrees; }
        public void setDegrees(int degrees) { Degrees = degrees; }
        public String getLocalized() { return Localized; }
        public void setLocalized(String localized) { Localized = localized; }
        public String getEnglish() { return English; }
        public void setEnglish(String english) { English = english; }
    }
}
