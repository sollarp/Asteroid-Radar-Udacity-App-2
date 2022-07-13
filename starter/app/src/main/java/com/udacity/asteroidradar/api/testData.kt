package com.udacity.asteroidradar.api


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.udacity.asteroidradar.Asteroid

@Keep
data class testData(
    @SerializedName("element_count")
    val elementCount: Int?,
    val links: Links?,
    @SerializedName("near_earth_objects")
    val nearEarthObjects: NearEarthObjects?
) {
    @Keep
    data class Links(
        val next: String?,
        val prev: String?,
        val self: String?
    )

    @Keep
    data class NearEarthObjects(
        @SerializedName("2022-05-22")
        val x20220522: List<X20220522?>?,
        @SerializedName("2022-05-23")
        val x20220523: List<X20220523?>?,
        @SerializedName("2022-05-24")
        val x20220524: List<X20220524?>?
    ) {
        @Keep
        data class X20220522(
            @SerializedName("absolute_magnitude_h")
            val absoluteMagnitudeH: Double?,
            @SerializedName("close_approach_data")
            val closeApproachData: List<CloseApproachData?>?,
            @SerializedName("estimated_diameter")
            val estimatedDiameter: EstimatedDiameter?,
            val id: String?,
            @SerializedName("is_potentially_hazardous_asteroid")
            val isPotentiallyHazardousAsteroid: Boolean?,
            @SerializedName("is_sentry_object")
            val isSentryObject: Boolean?,
            val links: Links?,
            val name: String?,
            @SerializedName("nasa_jpl_url")
            val nasaJplUrl: String?,
            @SerializedName("neo_reference_id")
            val neoReferenceId: String?
        ) {
            @Keep
            data class CloseApproachData(
                @SerializedName("close_approach_date")
                val closeApproachDate: String?,
                @SerializedName("close_approach_date_full")
                val closeApproachDateFull: String?,
                @SerializedName("epoch_date_close_approach")
                val epochDateCloseApproach: Long?,
                @SerializedName("miss_distance")
                val missDistance: MissDistance?,
                @SerializedName("orbiting_body")
                val orbitingBody: String?,
                @SerializedName("relative_velocity")
                val relativeVelocity: RelativeVelocity?
            ) {
                @Keep
                data class MissDistance(
                    val astronomical: String?,
                    val kilometers: String?,
                    val lunar: String?,
                    val miles: String?
                )

                @Keep
                data class RelativeVelocity(
                    @SerializedName("kilometers_per_hour")
                    val kilometersPerHour: String?,
                    @SerializedName("kilometers_per_second")
                    val kilometersPerSecond: String?,
                    @SerializedName("miles_per_hour")
                    val milesPerHour: String?
                )
            }

            @Keep
            data class EstimatedDiameter(
                val feet: Feet?,
                val kilometers: Kilometers?,
                val meters: Meters?,
                val miles: Miles?
            ) {
                @Keep
                data class Feet(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                @Keep
                data class Kilometers(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                @Keep
                data class Meters(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                @Keep
                data class Miles(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )
            }

            @Keep
            data class Links(
                val self: String?
            )
        }

        @Keep
        data class X20220523(
            @SerializedName("absolute_magnitude_h")
            val absoluteMagnitudeH: Double?,
            @SerializedName("close_approach_data")
            val closeApproachData: List<CloseApproachData?>?,
            @SerializedName("estimated_diameter")
            val estimatedDiameter: EstimatedDiameter?,
            val id: String?,
            @SerializedName("is_potentially_hazardous_asteroid")
            val isPotentiallyHazardousAsteroid: Boolean?,
            @SerializedName("is_sentry_object")
            val isSentryObject: Boolean?,
            val links: Links?,
            val name: String?,
            @SerializedName("nasa_jpl_url")
            val nasaJplUrl: String?,
            @SerializedName("neo_reference_id")
            val neoReferenceId: String?
        ) {
            @Keep
            data class CloseApproachData(
                @SerializedName("close_approach_date")
                val closeApproachDate: String?,
                @SerializedName("close_approach_date_full")
                val closeApproachDateFull: String?,
                @SerializedName("epoch_date_close_approach")
                val epochDateCloseApproach: Long?,
                @SerializedName("miss_distance")
                val missDistance: MissDistance?,
                @SerializedName("orbiting_body")
                val orbitingBody: String?,
                @SerializedName("relative_velocity")
                val relativeVelocity: RelativeVelocity?
            ) {
                @Keep
                data class MissDistance(
                    val astronomical: String?,
                    val kilometers: String?,
                    val lunar: String?,
                    val miles: String?
                )

                @Keep
                data class RelativeVelocity(
                    @SerializedName("kilometers_per_hour")
                    val kilometersPerHour: String?,
                    @SerializedName("kilometers_per_second")
                    val kilometersPerSecond: String?,
                    @SerializedName("miles_per_hour")
                    val milesPerHour: String?
                )
            }

            @Keep
            data class EstimatedDiameter(
                val feet: Feet?,
                val kilometers: Kilometers?,
                val meters: Meters?,
                val miles: Miles?
            ) {
                @Keep
                data class Feet(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                @Keep
                data class Kilometers(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                @Keep
                data class Meters(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                @Keep
                data class Miles(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )
            }

            @Keep
            data class Links(
                val self: String?
            )
        }

        @Keep
        data class X20220524(
            @SerializedName("absolute_magnitude_h")
            val absoluteMagnitudeH: Double?,
            @SerializedName("close_approach_data")
            val closeApproachData: List<CloseApproachData?>?,
            @SerializedName("estimated_diameter")
            val estimatedDiameter: EstimatedDiameter?,
            val id: String?,
            @SerializedName("is_potentially_hazardous_asteroid")
            val isPotentiallyHazardousAsteroid: Boolean?,
            @SerializedName("is_sentry_object")
            val isSentryObject: Boolean?,
            val links: Links?,
            val name: String?,
            @SerializedName("nasa_jpl_url")
            val nasaJplUrl: String?,
            @SerializedName("neo_reference_id")
            val neoReferenceId: String?
        ) {
            @Keep
            data class CloseApproachData(
                @SerializedName("close_approach_date")
                val closeApproachDate: String?,
                @SerializedName("close_approach_date_full")
                val closeApproachDateFull: String?,
                @SerializedName("epoch_date_close_approach")
                val epochDateCloseApproach: Long?,
                @SerializedName("miss_distance")
                val missDistance: MissDistance?,
                @SerializedName("orbiting_body")
                val orbitingBody: String?,
                @SerializedName("relative_velocity")
                val relativeVelocity: RelativeVelocity?
            ) {
                @Keep
                data class MissDistance(
                    val astronomical: String?,
                    val kilometers: String?,
                    val lunar: String?,
                    val miles: String?
                )

                @Keep
                data class RelativeVelocity(
                    @SerializedName("kilometers_per_hour")
                    val kilometersPerHour: String?,
                    @SerializedName("kilometers_per_second")
                    val kilometersPerSecond: String?,
                    @SerializedName("miles_per_hour")
                    val milesPerHour: String?
                )
            }

            @Keep
            data class EstimatedDiameter(
                val feet: Feet?,
                val kilometers: Kilometers?,
                val meters: Meters?,
                val miles: Miles?
            ) {
                @Keep
                data class Feet(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                @Keep
                data class Kilometers(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                @Keep
                data class Meters(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                @Keep
                data class Miles(
                    @SerializedName("estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @SerializedName("estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )
            }

            @Keep
            data class Links(
                val self: String?
            )
        }
    }
}